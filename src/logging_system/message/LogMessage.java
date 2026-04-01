package logging_system.message;

import logging_system.enums.LogLevel;

import java.util.Date;

public class LogMessage {

    private String message;
    private LogLevel logLevel;
    private Date timestamp;

    public LogMessage(LogLevel logLevel, String message) {
        this.logLevel = logLevel;
        this.message = message;
        this.timestamp = new Date();
    }

    public String getMessage() {
        return message;
    }

    public LogLevel getLogLevel() {
        return logLevel;
    }

    public Date getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "LogMessage{" +
                "message='" + message + '\'' +
                ", logLevel=" + logLevel +
                ", timestamp=" + timestamp +
                '}';
    }
}
