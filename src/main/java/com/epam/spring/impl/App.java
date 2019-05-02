package com.epam.spring.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.IEventLogger;


public class App
{
	private Client client;
	private IEventLogger eventLogger;
	private Event event;


	public App()
	{
	}

	private App(final Client client, final IEventLogger eventLogger)
	{
		this.client = client;
		this.eventLogger = eventLogger;
	}	

	public App(Client client, IEventLogger eventLogger, Event event) {
		this.client = client;
		this.eventLogger = eventLogger;
		this.event = event;
	}

	public static void main(final String[] args)
	{
		final ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("context.xml");
		final App app = context.getBean("app",App.class);

		app.logEvent(app.getEvent());
		context.close();
	}

	// call to eventLogger
	public void logEvent(final Event event)
	{
		event.setMessage(event.getMessage().replaceAll(client.getId(), client.getFullName()));
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

	public void setEventLogger(final IEventLogger eventLogger)
	{
		this.eventLogger = eventLogger;
	}

	public IEventLogger getEventLogger()
	{
		return eventLogger;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}
}
