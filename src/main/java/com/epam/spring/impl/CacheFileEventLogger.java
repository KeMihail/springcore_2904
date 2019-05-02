package com.epam.spring.impl;

import java.util.List;


public class CacheFileEventLogger extends FileEventLogger
{
	private Integer cacheSize;
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

	public void destroy(){
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
	private void writeToFile(){

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
