package com.epam.spring.impl;

import com.epam.spring.IEventLogger;


public class ConsoleEventLogger implements IEventLogger
{
	public void logEvent(final Event event)
	{
		System.out.println(event);
	}
}
