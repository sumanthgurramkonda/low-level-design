package otp_service;

import otp_service.entity.OTP;

import java.util.HashMap;
import java.util.Map;

public class OTPDB {

    private Map<String, OTP> otps;

    public OTPDB() {
        this.otps = new HashMap<>();
    }

    public void addOTP(OTP otp) {
        otps.put(otp.getCode(), otp);
    }

    public OTP getOTP(String code) {
        return otps.get(code);
    }



}
