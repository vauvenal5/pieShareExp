/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.common;

import java.io.File;
import java.io.Serializable;

/**
 *
 * @author richy
 * 
 * Represents an File or Directory or cream for pie
 */
public class PieceOfPie implements Serializable
{
	private String name = "";
	private long lastModified = 0;
	
	public PieceOfPie(File file)
	{
		this.name = file.getName();
		this.lastModified = file.lastModified();
	}
	
	public PieceOfPie()
	{
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public long getLastModified()
	{
		return lastModified;
	}

	public void setLastModified(long lastModified)
	{
		this.lastModified = lastModified;
	}
}
