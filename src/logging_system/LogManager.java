package logging_system;

import logging_system.appender.ConsoleAppender;
import logging_system.appender.FileAppender;
import logging_system.enums.LogLevel;
import logging_system.log_observer.LogObserver;
import logging_system.logger.AbstractLogger;
import logging_system.logger.DebugLogger;
import logging_system.logger.ErrorLogger;
import logging_system.logger.InfoLogger;

public class LogManager {

    public static AbstractLogger buildLoggChain() {

        AbstractLogger infoLogger = new InfoLogger();
        AbstractLogger debugLogger = new DebugLogger();
        AbstractLogger errorLogger = new ErrorLogger();

        infoLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(errorLogger);

        return infoLogger;
    }

    public static LogObserver setLogObserver() {
        LogObserver logObserver = new LogObserver();
        logObserver.setLogObserver(LogLevel.INFO, new FileAppender());
        logObserver.setLogObserver(LogLevel.DEBUG, new FileAppender());
        logObserver.setLogObserver(LogLevel.ERROR, new FileAppender());

        logObserver.setLogObserver(LogLevel.INFO, new ConsoleAppender());
        logObserver.setLogObserver(LogLevel.DEBUG, new ConsoleAppender());
        logObserver.setLogObserver(LogLevel.ERROR, new ConsoleAppender());


        return logObserver;
    }
}
