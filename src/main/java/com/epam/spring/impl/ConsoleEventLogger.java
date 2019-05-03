package com.epam.spring.impl;

import org.springframework.stereotype.Component;

import com.epam.spring.IEventLogger;

@Component
public class ConsoleEventLogger implements IEventLogger
{
	public void logEvent(final Event event)
	{
		System.out.println(event);
	}
}
