package com.epam.spring.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.PropertyPlaceholderConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class AppConfig
{

	@Autowired(required = false)
	private PropertyPlaceholderConfigurer propertyPlaceholderConfigurer;

	@Bean()
	public Client client()
	{
		return new Client();
	}

	@Bean()
	public App app()
	{
		return new App();
	}

	@Bean()
	public CacheFileEventLogger cacheFileEventLogger()
	{
		return new CacheFileEventLogger();
	}

	@Bean()
	public CombinedEventLogger combinedEventLogger()
	{
		return new CombinedEventLogger();
	}

	@Bean()
	public ConsoleEventLogger consoleEventLogger()
	{
		return new ConsoleEventLogger();
	}

	@Bean()
	public Event event()
	{
		return new Event();
	}

	@Bean()
	public FileEventLogger fileEventLogger()
	{
		return new FileEventLogger();
	}

	@Bean
	public ArrayList emptylist()
	{
		return new ArrayList();
	}

	@Bean
	public LocalDateTime datelog()
	{
		return LocalDateTime.now();
	}

	@Bean
	public Map<String, String> loggers()
	{

		Map<String, String> map = new HashMap<>();
		map.put("ERROR", "sdvf");
		map.put("INFO", "dsfgvdf");

		return map;
	}

/*	@Bean
	public PropertyPlaceholderConfigurer propertyPlaceholderConfigurer()
	{
		return propertyPlaceholderConfigurer;
	}*/
}
