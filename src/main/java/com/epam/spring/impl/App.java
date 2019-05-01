package com.epam.spring.impl;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.epam.spring.IEventLogger;


public class App
{
	private Client client;
	private IEventLogger eventLogger;


	public App()
	{
	}

	private App(final Client client, final IEventLogger eventLogger)
	{
		this.client = client;
		this.eventLogger = eventLogger;
	}

	public static void main(final String[] args)
	{
		final ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml","spring1.xml");
		final App app = context.getBean("app",App.class);

		String msg = "Hello 1";
		app.logEvent(msg);
	}

	// call to eventLogger
	public void logEvent(final String msg)
	{
		String message = msg.replaceAll(client.getId(), client.getFullName());
		eventLogger.logEvent(message);
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
}
