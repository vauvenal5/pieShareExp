/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.propertiesreader;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Properties;
import org.apache.log4j.Logger;
import org.pieshare.common.IDirectoryService;

/**
 *
 * @author richy
 */
public class PropertiesReaderBaseService
{

	private static final Logger logger = Logger.getLogger(PropertiesReaderBaseService.class);
	protected Properties properties = new Properties();
	private IDirectoryService directoryService;
	private String fileName = "";

	public void setDirectoryService(IDirectoryService directoryService)
	{
		this.directoryService = directoryService;
		getReader();
	}

	public PropertiesReaderBaseService(String fileName)
	{
		this.fileName = fileName;
	}

	private void getReader()
	{
		try
		{
			FileInputStream fileInputStream = new FileInputStream(directoryService.getUserPieShareDirectory() + "/" + fileName);
			properties.load(fileInputStream);
			fileInputStream.close();
		}
		catch (IOException ex)
		{
			logger.error("Not able to load properties file. Message: " + ex.getMessage());
		}
	}
}
