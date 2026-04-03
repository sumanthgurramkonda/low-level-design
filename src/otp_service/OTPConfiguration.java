package otp_service;

import otp_service.enums.OTPType;

public class OTPConfiguration {

    private OTPType otpType;
    private int otpLength;
    private long otpExpirationTime;

    public OTPConfiguration(OTPType otpType, int otpLength, long otpExpirationTime) {
        this.otpType = otpType;
        this.otpLength = otpLength;
        this.otpExpirationTime = otpExpirationTime;
    }

    public OTPType getOtpType() {
        return otpType;
    }

    public int getOtpLength() {
        return otpLength;
    }

    public long getOtpExpirationTime() {
        return otpExpirationTime;
    }

    public void setOtpType(OTPType otpType) {
        this.otpType = otpType;
    }

    public void setOtpLength(int otpLength) {
        this.otpLength = otpLength;
    }

    public void setOtpExpirationTime(long otpExpirationTime) {
        this.otpExpirationTime = otpExpirationTime;
    }
}
