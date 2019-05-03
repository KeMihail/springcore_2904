package com.epam.spring.impl;

import java.util.Map;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.epam.spring.IEventLogger;


@Component
public class App
{

	//@Resource(name = "client")
	private Client client;
	//@Resource(name = "cacheFileEventLogger")
	private IEventLogger eventLogger;
	//@Resource(name = "event")
	private Event event;
	//  @Resource(name = "loggers")
	private Map<EventType, IEventLogger> loggers;

	public App()
	{
	}

	public App(Client client, IEventLogger eventLogger, Event event, Map<EventType, IEventLogger> loggers)
	{
		this.client = client;
		this.eventLogger = eventLogger;
		this.event = event;
		this.loggers = loggers;
	}

	public static void main(final String[] args)
	{

		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("context.xml");

		/*annotation config:*/
		/*  final AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);*/
		final App app = context.getBean("app", App.class);

		app.logEvent(app.getEvent());
		context.close();
	}

	// call to eventLogger
	public void logEvent(final Event event)
	{
		event.setMessage(event.getMessage().replaceAll(client.getId(), client.getFullName()));
		eventLogger = loggers.get(EventType.INFO);
		eventLogger.logEvent(event);
	}

	public Client getClient()
	{
		return client;
	}

	public void setClient(final Client client)
	{
		this.client = client;
	}

	public IEventLogger getEventLogger()
	{
		return eventLogger;
	}

	public void setEventLogger(final IEventLogger eventLogger)
	{
		this.eventLogger = eventLogger;
	}

	public Event getEvent()
	{
		return event;
	}

	public void setEvent(Event event)
	{
		this.event = event;
	}

	public Map<EventType, IEventLogger> getLoggers()
	{
		return loggers;
	}

	public void setLoggers(Map<EventType, IEventLogger> loggers)
	{
		this.loggers = loggers;
	}
}
