/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.common;

/**
 *
 * @author richy
 * 
 * Represents an File or Directory or cream for pie
 */
public class PieceOfPie
{
	private String name = "";
	private long lastModified = 0;
	

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
