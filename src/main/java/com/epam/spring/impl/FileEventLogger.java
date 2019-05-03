package com.epam.spring.impl;

import java.io.File;
import java.io.IOException;

import javax.annotation.PostConstruct;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import com.epam.spring.IEventLogger;

@Component
public class FileEventLogger implements IEventLogger
{
	@Value("D:\\file_logger.txt")
	private String filename;
	private File file;

	@PostConstruct
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
