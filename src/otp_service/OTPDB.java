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
        if(otps.containsKey(otp.getCode())) return false;
        otps.put(otp.getCode(), otp);
        queue.add(otp);
        return true;
    }

    private void removeExpiredOTPs() {
        long now = System.currentTimeMillis();
        while (!queue.isEmpty() && now > queue.peek().getExpirationTime()) {
            OTP expiredOtp = queue.poll();
            if (expiredOtp != null && otps.containsKey(expiredOtp.getCode())) {
                otps.remove(expiredOtp.getCode());
            }
        }
    }

    public OTP getOTP(String code) {
        return otps.getOrDefault(code,null);
    }

    public void removeOTP(String code) {
        otps.remove(code);
    }

}
