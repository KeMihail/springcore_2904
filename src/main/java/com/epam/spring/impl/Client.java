package com.epam.spring.impl;


import java.time.LocalTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Client
{
	@Value("${id}")
	private String id;
	@Value("${name}")
	private String fullName;

	public Client()
	{
	}

	public Client(final String id, final String fullName)
	{
		this.id = id;
		this.fullName = fullName;
	}

	public static Boolean isDay(){

		final LocalTime currentTime = LocalTime.now();

		if (currentTime.isBefore(LocalTime.of(8,00,00)) || currentTime.isAfter(LocalTime.of(17,00,00))){
			return false;
		}

		return true;
	}

	public void setFullName(final String fullName)
	{
		this.fullName = fullName;
	}

	public String getFullName()
	{
		return fullName;
	}

	public String getId()
	{
		return id;
	}

	public void setId(final String id)
	{
		this.id = id;
	}
}
