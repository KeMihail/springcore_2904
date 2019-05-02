package com.epam.spring;

import java.io.IOException;

import com.epam.spring.impl.Event;

public interface IEventLogger
{
	void logEvent(final Event event);
}
