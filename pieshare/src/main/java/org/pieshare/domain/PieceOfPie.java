/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.domain;

import java.io.File;
import java.io.Serializable;
import java.nio.file.WatchEvent;
import org.pieshare.service.core.filehashgenerator.FileHashGeneratorException;
import org.pieshare.service.core.filehashgenerator.IFileHashGenerator;

/**
 *
 * @author richy
 *
 * Represents an File or Directory or cream for pie
 */
public class PieceOfPie implements Serializable
{

	private IPieceOfPieEntity pieceOfPieEntity;
	private File file;
	private WatchEvent.Kind<?> kind = null;
	private IFileHashGenerator fileHashGenerator;

	
	public PieceOfPie(File file, WatchEvent.Kind<?> kind)
	{
		this.kind = kind;
		this.file = file;
		//this.lastModified = file.lastModified();
	}
	
	public PieceOfPie(File file)
	{
		this.file = file;
	}

	public PieceOfPie()
	{
	}

	public void createNewPiece(String path) throws FileHashGeneratorException
	{
		pieceOfPieEntity = new PieceOfPieEntity();
		File f = pieceOfPieEntity.autoFillValues(path);
		String hash = fileHashGenerator.getMD5ChecksumHex(f);
		pieceOfPieEntity.setFileHash(hash);
	}
	
	public void setFileHashGenerator(IFileHashGenerator fileHashGenerator)
	{
		this.fileHashGenerator = fileHashGenerator;
	}
	
	public IPieceOfPieEntity getPieceOfPieEntity() throws NoEntityException
	{
		if(pieceOfPieEntity == null)
		{
			throw new NoEntityException("No Entity is set in PiecOfPie");
		}
		
		return pieceOfPieEntity;
	}

	
	public void setPieceOfPieEntity(IPieceOfPieEntity pieceOfPieEntity)
	{
		this.pieceOfPieEntity = pieceOfPieEntity;
	}	
}
