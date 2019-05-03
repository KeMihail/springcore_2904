package com.epam.spring.impl;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class Client
{
	@Value("1")
	private String id;
	@Value("Hello 1")
	private String fullName;

	public Client()
	{
	}

	public Client(final String id, final String fullName)
	{
		this.id = id;
		this.fullName = fullName;
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
