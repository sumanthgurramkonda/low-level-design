package logging_system.log_observer;

import logging_system.appender.LogAppender;
import logging_system.enums.LogLevel;
import logging_system.message.LogMessage;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LogObserver {
    private Map<LogLevel, List<LogAppender>> observers = new HashMap<>();

    public LogObserver() {
    }

    public void setLogObserver(LogLevel level, LogAppender appender) {
        observers.putIfAbsent(level,new ArrayList<>());
        observers.get(level).add(appender);
    }

    public void setLogObserver(LogLevel level, List<LogAppender> appenders) {
        observers.putIfAbsent(level,appenders);
    }
    
    public void notifyObservers(LogMessage message){
        List<LogAppender> appenders = observers.get(message.getLogLevel());
        if (appenders != null) {
            for (LogAppender appender : appenders) {
                appender.append(message);
            }
        }
    }

}
