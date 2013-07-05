/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.cloudManagement.pieDB;

import javax.annotation.PostConstruct;
import org.apache.log4j.Logger;
import org.pieshare.user.User;

/**
 *
 * @author richy
 */
public class PieDB extends org.apache.commons.dbcp.BasicDataSource
{

	private final static Logger logger = Logger.getLogger(PieDB.class);
	private User user;

	@Override
	public synchronized void setDriverClassName(String driverClassName)
	{
		super.setDriverClassName(driverClassName); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public synchronized void setUrl(String url)
	{
		super.setUrl(url); //To change body of generated methods, choose Tools | Templates.
	}

	@PostConstruct
	public void setupDB()
	{
		if (user != null)
		{
			super.setPassword(user.getPasswort());
			super.setUsername(user.getUsername());
		}
		else
		{
			logger.error("No user is logged in, how could this happen that we ended up here?");
		}
	}
}
