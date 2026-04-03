package otp_service;

import otp_service.entity.OTP;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.LinkedBlockingQueue;

public class OTPDB {

    private ConcurrentHashMap<String, OTP> otps;
    private LinkedBlockingQueue<OTP> queue;
    private OTPConfiguration otpConfiguration;

    public OTPDB(OTPConfiguration otpConfiguration) {
        this.otps = new ConcurrentHashMap<>();
        this.otpConfiguration = otpConfiguration;
        this.queue = new LinkedBlockingQueue <>();

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    Thread.sleep(otpConfiguration.getOtpExpirationTime() / 2);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                this.removeExpiredOTPs();
            }
        });
        thread.setDaemon(true);
        thread.start();
    }

    public boolean addOTPIfAbsent(OTP otp) {
        if (otps.putIfAbsent(otp.getCode(), otp) == null) {
            queue.add(otp);
            return true;
        }
        return false;
    }

    private void removeExpiredOTPs() {
        long now = System.currentTimeMillis();
        while (true) {
            OTP otp = queue.peek();
            if (otp == null || otp.getExpirationTime() > now) {
                break;
            }
            System.out.println("Opt expired: " + otp.getCode());
            queue.poll();
            otps.remove(otp.getCode());
        }
    }

    public OTP getOTP(String code) {
        return otps.get(code);
    }

    public void removeOTP(String code) {
        otps.remove(code);
    }

}
