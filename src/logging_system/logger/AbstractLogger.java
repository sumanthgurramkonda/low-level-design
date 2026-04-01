package logging_system.logger;

import logging_system.enums.LogLevel;
import logging_system.log_observer.LogObserver;
import logging_system.message.LogMessage;

public abstract class AbstractLogger {

    protected AbstractLogger nextHandler;
    protected LogLevel logLevel;

    public AbstractLogger(LogLevel logLevel) {
        this.logLevel = logLevel;
    }

    public void setNextLogger(AbstractLogger nextHandler) {
        this.nextHandler = nextHandler;
    }

    public void log(LogMessage message, LogObserver observer) {
        if (this.logLevel!=null && this.logLevel == message.getLogLevel()) {
            publishLog(message,observer);
        }
        if(nextHandler!=null) {
            nextHandler.log(message, observer);
        }
    }

    public abstract void publishLog(LogMessage message, LogObserver observer);

}
