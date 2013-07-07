/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.database;

import java.util.Properties;
import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.pieshare.common.IDirectoryService;
import org.pieshare.propertiesreader.AppDataPropertiesReader;
import org.pieshare.propertiesreader.IAppDataPropertiesReader;
import org.pieshare.user.User;

/**
 *
 * @author richy
 */
public class PieAppDB extends org.apache.commons.dbcp.BasicDataSource
{

	private final static Logger logger = Logger.getLogger(PieAppDB.class);
	private User appUser;
	private IAppDataPropertiesReader appDataPropertiesReader;

	public void setAppDataPropertiesReader(IAppDataPropertiesReader appDataPropertiesReader)
	{
		this.appDataPropertiesReader = appDataPropertiesReader;
	}

	@Override
	public synchronized void setDriverClassName(String driverClassName)
	{
		super.setDriverClassName(driverClassName);
	}

	@Override
	public synchronized void setUrl(String url)
	{
		super.setUrl(url);
	}

	@PostConstruct
	public void setupDB()
	{
		appUser = createAppUser();

		if (appUser != null)
		{
			super.setPassword(appUser.getPasswort());
			super.setUsername(appUser.getUsername());
		}
		else
		{
			logger.error("No user is logged in, how could this happen that we ended up here?");
		}
	}

	private User createAppUser()
	{
		return new User(appDataPropertiesReader.getUsername(), appDataPropertiesReader.getPassword());
	}
}
