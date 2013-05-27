/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.common;

import java.io.File;
import java.io.Serializable;
import java.nio.file.WatchEvent;

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
	private WatchEvent.Kind<?> kind = null;
	
	public PieceOfPie(File file, WatchEvent.Kind<?> kind)
	{
		this.kind = kind;
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
