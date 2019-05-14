package com.epam.spring.impl.combin;

import com.epam.spring.IEventLogger;
import com.epam.spring.impl.Event;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class CombinedEventLogger implements IEventLogger {

   /* @Resource(name = "loggers")*/
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
