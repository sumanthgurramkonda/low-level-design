package otp_service;

import otp_service.entity.OTP;

import java.security.SecureRandom;

public class OTPService {

    private OTPConfiguration otpConfiguration;
    private OTPDB otpDB;
    private final SecureRandom secureRandom = new SecureRandom();
    public OTPService(OTPConfiguration otpConfiguration) {
        this.otpConfiguration = otpConfiguration;
        this.otpDB = new OTPDB(otpConfiguration);
    }

    public OTP generateOTP() {
        while (true) {
            String code = generateCode();

            OTP otp = new OTP(code, System.currentTimeMillis() + otpConfiguration.getOtpExpirationTime());
            if (otpDB.addOTPIfAbsent(otp)) {
                return otp;
            }
        }
    }

    public synchronized boolean validateOTP(String inputCode) {
        if (inputCode == null || inputCode.isEmpty()) return false;

        OTP otp = otpDB.getOTP(inputCode);
        if (otp == null) return false;

        otpDB.removeOTP(inputCode);
        long now = System.currentTimeMillis();
        return now <= otp.getExpirationTime();
    }

    private String generateCode() {

        StringBuilder code = new StringBuilder();
        int length = otpConfiguration.getOtpLength();

        for (int i = 0; i < length; i++) {
            switch (otpConfiguration.getOtpType()) {
                case STRING -> code.append((char) (secureRandom.nextInt(26) + 'a'));
                case NUMBER -> code.append((char) (secureRandom.nextInt(10) + '0'));
                case ALPHANUMERIC -> {
                    int random = secureRandom.nextInt(36);
                    code.append(random < 10 ? (char) (random + '0') : (char) (random - 10 + 'a'));
                }
            }
        }
        return code.toString();
    }
}
