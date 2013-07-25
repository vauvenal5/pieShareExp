/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author richy
 */
public class PieLogger
{

	private static Logger mainLogger = LoggerFactory.getLogger(PieLogger.class);

	public PieLogger()
	{
	}

	public static void debug(Class clazz, String message)
	{
		if (mainLogger.isDebugEnabled())
		{
			Logger logger = LoggerFactory.getLogger(clazz);
			logger.debug(message);
		}
	}
	
	public static void error(Class clazz, String message)
	{
		if (mainLogger.isErrorEnabled())
		{
			Logger logger = LoggerFactory.getLogger(clazz);
			logger.debug(message);
		}
	}
}
