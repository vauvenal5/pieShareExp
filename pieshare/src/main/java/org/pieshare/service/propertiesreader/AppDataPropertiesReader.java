/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.propertiesreader;

import java.util.Properties;
import org.pieshare.service.core.IDirectoryService;

/**
 *
 * @author richy
 */
public class AppDataPropertiesReader extends PropertiesReaderBaseService implements IAppDataPropertiesReader
{

	public AppDataPropertiesReader()
	{
		super("appData.properties");
	}

	@Override
	public String getPassword()
	{
		if (this.properties != null)
		{
			return this.properties.getProperty("password");
		}
		else
		{
			//ToDo: return something serious
			return "";
		}

	}

	@Override
	public String getUsername()
	{
		if (this.properties != null)
		{
			return this.properties.getProperty("username");
		}
		else
		{
			//ToDo: return something serious
			return "";
		}
	}
}
