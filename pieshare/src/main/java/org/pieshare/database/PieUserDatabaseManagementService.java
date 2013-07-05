/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.database;

import java.util.HashMap;
import org.apache.commons.dbcp.BasicDataSource;
import org.apache.log4j.Logger;
import org.pieshare.user.User;

/**
 *
 * @author richy
 */
public class PieUserDatabaseManagementService implements IPieUserDatabaseManagerService
{
	private static final Logger logger = Logger.getLogger(PieUserDatabaseManagementService.class);
	private HashMap<String, BasicDataSource> databaseList = new HashMap<>();
	private String path = "";
	
	@Override
	public void setDatabasePath(String path)
	{
		this.path = path;
	}
	
	@Override
	public BasicDataSource getDataSource(User user)
	{
		if(path == null)
		{
			path = "";
		}
		
		if(databaseList.containsKey(user.getUsername()))
		{
			return databaseList.get(user.getUsername());
		}
		else
		{
			BasicDataSource dataSource = new BasicDataSource();
			dataSource.setDriverClassName("org.sqlite.JDBC");
			dataSource.setUrl("jdbc:sqlite:"+user.getUsername()+".db");
			dataSource.setUsername(user.getUsername());
			dataSource.setPassword(user.getPasswort());
			databaseList.put(user.getUsername(), dataSource);
			return dataSource;
		}
	}
}
