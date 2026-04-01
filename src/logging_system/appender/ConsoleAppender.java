package logging_system.appender;

import logging_system.message.LogMessage;

public class ConsoleAppender implements LogAppender{

    @Override
    public void append(LogMessage message) {
        // Code to write the log message to the console
        System.out.println("ConsoleAppender: " + message);
    }
}
