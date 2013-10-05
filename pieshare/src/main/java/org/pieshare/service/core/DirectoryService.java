/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.core;

import java.io.File;

/**
 *
 * @author richy
 */
public class DirectoryService implements IDirectoryService
{

	@Override
	public File getOSUserDirectory()
	{
		return new File(System.getProperty("user.home"));
	}

	@Override
	public File getTempPieShareDirectory()
	{
		File userPieShare = new File(getOSUserDirectory(), ".pieshare");

		if (!userPieShare.exists() || !userPieShare.isDirectory())
		{
			userPieShare.mkdirs();
		}

		return userPieShare;

	}

	@Override
	public File getCurrentCookingDirectory()
	{
		File w =  new File("../TestWorkingDirectory");
		if (!w.exists() || !w.isDirectory())
		{
			w.mkdirs();
		}
		return w;
	}
}
