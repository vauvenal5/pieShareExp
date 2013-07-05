/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.common;

import java.io.File;

/**
 *
 * @author richy
 */
public class DirectoryService implements IDirectoryService
{
	public File getUserDirectory()
	{
		return new File(System.getProperty("user.home"));
	}
	
	public File getUserPieShareDirectory()
	{
		File userPieShare = new File(getUserDirectory(), ".pieshare");
		
		if(!userPieShare.exists() || !userPieShare.isDirectory())
		{
			userPieShare.mkdirs();
		}
		
		return userPieShare;
		
	}
	
}
