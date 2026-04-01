package logging_system.appender;

import logging_system.log_observer.LogObserver;
import logging_system.message.LogMessage;

public class FileAppender implements LogAppender {

    @Override
    public void append(LogMessage message) {
        // Code to write the log message to a file
        System.out.println("FileAppender: " + message);
    }
}
