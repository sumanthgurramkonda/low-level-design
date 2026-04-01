package logging_system;

import logging_system.appender.ConsoleAppender;
import logging_system.appender.FileAppender;
import logging_system.enums.LogLevel;
import logging_system.log_observer.LogObserver;
import logging_system.logger.AbstractLogger;
import logging_system.logger.InfoLogger;
import logging_system.message.LogMessage;

import java.util.ArrayList;

public class Logger {

        private static Logger instance;
        private static LogObserver observer = LogManager.setLogObserver();
        private static AbstractLogger abstractLogger = LogManager.buildLoggChain();


        private Logger() {
        }

        public static Logger getInstance() {
            if(instance == null) {
                synchronized (Logger.class) {
                    if (instance == null) {
                        instance = new Logger();
                    }
                    return instance;
                }
            }
            return instance;
        }

        private void log(String message, LogLevel level) {
            LogMessage logMessage = new LogMessage(level,message);
            abstractLogger.log(logMessage, observer);
        }

        public void info(String message) {
            log(message, LogLevel.INFO);
        }
        public  void debug(String message) {
            log(message, LogLevel.DEBUG);
        }
        public void error(String message) {
            log(message, LogLevel.ERROR);
        }
}
