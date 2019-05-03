package com.epam.spring.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.IEventLogger;

import java.util.Map;
import java.util.Properties;


public class App {
    private Client client;
    private IEventLogger eventLogger;
    private Event event;
    private Map<EvenType, IEventLogger> loggers;


    public App() {
    }

    public App(Client client, IEventLogger eventLogger, Event event, Map<EvenType, IEventLogger> loggers) {
        this.client = client;
        this.eventLogger = eventLogger;
        this.event = event;
        this.loggers = loggers;
    }

    public static void main(final String[] args) {
        final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
        final App app = context.getBean("app", App.class);


        final Properties properties = context.getBean("clientProp",Properties.class);
        System.out.println(properties);

        final String pr = properties.getProperty("id");
        System.out.println(pr);


        app.logEvent(app.getEvent());
        context.close();
    }

    // call to eventLogger
    public void logEvent(final Event event) {
        event.setMessage(event.getMessage().replaceAll(client.getId(), client.getFullName()));
        eventLogger = loggers.get(EvenType.INFO);
        eventLogger.logEvent(event);
    }

    public Client getClient() {
        return client;
    }

    public void setClient(final Client client) {
        this.client = client;
    }

    public void setEventLogger(final IEventLogger eventLogger) {
        this.eventLogger = eventLogger;
    }

    public IEventLogger getEventLogger() {
        return eventLogger;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }

    public void setLoggers(Map<EvenType, IEventLogger> loggers) {
        this.loggers = loggers;
    }
}
