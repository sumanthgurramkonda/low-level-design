package logging_system.logger;

import logging_system.enums.LogLevel;
import logging_system.log_observer.LogObserver;
import logging_system.message.LogMessage;

public class ErrorLogger extends AbstractLogger {

    public ErrorLogger() {
        super(LogLevel.ERROR);
    }

    @Override
    public void publishLog(LogMessage message, LogObserver observer) {
        observer.notifyObservers(message);
    }
}
