package com.epam.spring.impl;

import com.epam.spring.IEventLogger;

import java.util.List;

public class CombinedEventLogger implements IEventLogger {

    private List<IEventLogger> loggers;

    @Override
    public void logEvent(Event event) {

        for(IEventLogger logger : loggers){
            logger.logEvent(event);
        }
    }

    public void setLoggers(List<IEventLogger> loggers) {
        this.loggers = loggers;
    }
}
