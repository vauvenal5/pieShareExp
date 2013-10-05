/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.domain;

import java.io.File;
import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 *
 * @author richy
 */
@Entity
public class PieceOfPieEntity implements IPieceOfPieEntity, Serializable
{
	@Id // @Id indicates that this it a unique primary key
	@GeneratedValue 
	private Long id;
	
	private String fileName;
	private String filePath;
	private long lastModified;
	private String fileHash;

	
	@Override
	public File autoFillValues(String path)
	{
		File file = new File(path);
		this.filePath = path;
		this.fileName = file.getName();
		this.lastModified = file.lastModified();
		return file;
	}
	
	@Override
	public String getFileName()
	{
		return fileName;
	}

	@Override
	public void setFileName(String fileName)
	{
		this.fileName = fileName;
	}

	@Override
	public String getPath()
	{
		return filePath;
	}

	@Override
	public void setPath(String path)
	{
		this.filePath = path;
	}

	@Override
	public long getLastModified()
	{
		return lastModified;
	}

	@Override
	public void setLastModified(long lastModified)
	{
		this.lastModified = lastModified;
	}

	@Override
	public String getFileHash()
	{
		return fileHash;
	}

	@Override
	public void setFileHash(String fileHash)
	{
		this.fileHash = fileHash;
	}
	
}
