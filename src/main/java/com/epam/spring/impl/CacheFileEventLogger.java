package com.epam.spring.impl;

import java.util.List;

import javax.annotation.PreDestroy;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class CacheFileEventLogger extends FileEventLogger
{
	@Value("10")
	private Integer cacheSize;
	@Resource(name = "emptylist")
	private List<Event> cache;

	@Override
	public void logEvent(final Event event)
	{

		if (cache.size() <= cacheSize)
		{
			cache.add(event);
		}
		else
		{
			writeToFile();
		}
	}

	@PreDestroy
	public void destroy()
	{
		writeToFile();
	}

	public Integer getCacheSize()
	{
		return cacheSize;
	}

	public void setCacheSize(final Integer cacheSize)
	{
		this.cacheSize = cacheSize;
	}

	public List<Event> getCache()
	{
		return cache;
	}

	public void setCache(final List<Event> cache)
	{
		this.cache = cache;
	}

	private void writeToFile()
	{

		if (!cache.isEmpty())
		{
			for (final Event ev : cache)
			{
				super.logEvent(ev);
			}
			cache.clear();
		}
	}
}
