package otp_service.entity;

public class OTP {

    private String code;
    private long currentTimeMillis;

    public OTP(String code, long currentTimeMillis) {
        this.code = code;
        this.currentTimeMillis = currentTimeMillis;
    }

    public String getCode() {
        return code;
    }

    public long getCurrentTimeMillis() {
        return currentTimeMillis;
    }

    public boolean isExpired() {
        return System.currentTimeMillis() > currentTimeMillis;
    }
}
