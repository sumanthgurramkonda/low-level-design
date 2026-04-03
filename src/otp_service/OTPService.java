package otp_service;

import otp_service.entity.OTP;

public class OTPService {

    private OTPConfiguration otpConfiguration;
    private OTPDB otpDB;

    public OTPService(OTPConfiguration otpConfiguration) {
        this.otpConfiguration = otpConfiguration;
        this.otpDB = new OTPDB();
    }

    public OTP generateOTP() {
        String code = generateCode();
        if(otpDB.getOTP(code) != null) {
            return generateOTP();
        }
        OTP otp = new OTP(code, System.currentTimeMillis() + otpConfiguration.getOtpExpirationTime());
        otpDB.addOTP(otp);
        return otp;
    }

    public boolean validateOTP(String inputCode) {
        if (inputCode == null || inputCode.isEmpty()) {
            return false;
        }
        OTP otp = otpDB.getOTP(inputCode);
        if (otp == null || otp.isExpired()) {
            return false;
        }
        return otp.getCode().equals(inputCode);
    }

    private String generateCode() {

        StringBuilder code = new StringBuilder();
        for (int i = 0; i < otpConfiguration.getOtpLength(); i++) {
            switch (otpConfiguration.getOtpType()) {
                case STRING:
                    code.append((char) (Math.random() * 26 + 'a'));
                    break;
                case NUMBER:
                    code.append((char) (Math.random() * 10 + '0'));
                    break;
                case ALPHANUMERIC:
                    int random = (int) (Math.random() * 36);
                    if (random < 10) {
                        code.append((char) (random + '0'));
                    } else {
                        code.append((char) (random - 10 + 'a'));
                    }
                    break;
            }
        }

        return code.toString();
    }
}
