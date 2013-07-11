/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.common;

import org.apache.log4j.Logger;

/**
 *
 * @author vauve_000
 */
public abstract class PieObject extends Object
{
	protected final Logger logger;
	
	public PieObject()
	{
		logger = Logger.getLogger(this.getClass());
	}
}
