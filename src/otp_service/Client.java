package otp_service;

import otp_service.entity.OTP;
import otp_service.enums.OTPType;

public class Client {

    public static void main(String[] args) {
        OTPConfiguration otpConfiguration = new OTPConfiguration(OTPType.ALPHANUMERIC, 6, 3000);
        OTPService otpService = new OTPService(otpConfiguration);

        OTP otp = otpService.generateOTP();
        System.out.println("Generated OTP: " + otp.getCode());

        boolean isValid;
//        isValid = otpService.validateOTP(otp.getCode());
//        System.out.println("Is OTP valid? " + isValid);
        try {
            System.out.println("Waiting for OTP to expire...");
            for(int i = 1; i < 10; i++) {
                System.out.print(i+" ");
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println();
        isValid = otpService.validateOTP (otp.getCode());
        System.out.println("Is OTP valid after second validation? " + (isValid ? "Yes" : "Expired"));
    }
}
