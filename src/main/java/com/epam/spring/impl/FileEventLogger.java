package com.epam.spring.impl;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.epam.spring.IEventLogger;


public class FileEventLogger implements IEventLogger
{
	private String filename;
	private File file;

	public void init(){

		this.file = new File(filename);
		file.canWrite();
	}

	public void logEvent(final Event event)
	{

		try
		{
			FileUtils.writeStringToFile(file, event.toString(),true);
		}catch(IOException e){
			System.out.println(e.getMessage());
		}
	}

	public String getFilename()
	{
		return filename;
	}

	public void setFilename(final String filename)
	{
		this.filename = filename;
	}
}
