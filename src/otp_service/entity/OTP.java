package otp_service.entity;

public class OTP {

    private String code;
    private long expirationTime;

    public OTP(String code, long currentTimeMillis) {
        this.code = code;
        this.expirationTime = currentTimeMillis;
    }

    public String getCode() {
        return code;
    }

    public long getExpirationTime() {
        return expirationTime;
    }

}
