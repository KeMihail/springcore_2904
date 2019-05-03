package com.epam.spring.impl;


public class Client
{
	private String id;
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
