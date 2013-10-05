/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.domain;

import java.io.File;

/**
 *
 * @author richy
 */
public interface IPieceOfPieEntity
{
	public File autoFillValues(String path);
	
	public String getFileName();

	public void setFileName(String fileName);

	public String getPath();

	public void setPath(String path);

	public long getLastModified();

	public void setLastModified(long lastModified);

	public String getFileHash();

	public void setFileHash(String fileHash);
	
}
