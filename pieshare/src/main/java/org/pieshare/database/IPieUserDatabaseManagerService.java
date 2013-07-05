/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.database;

import org.apache.commons.dbcp.BasicDataSource;
import org.pieshare.user.User;

/**
 *
 * @author richy
 */
public interface IPieUserDatabaseManagerService
{
	BasicDataSource getDataSource(User user);
	
	/*
	 * Not used yet, use then if necessary
	 */
	void setDatabasePath(String path);
}
