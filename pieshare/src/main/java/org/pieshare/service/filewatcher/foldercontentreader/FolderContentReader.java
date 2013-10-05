/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.filewatcher.foldercontentreader;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import org.pieshare.domain.PieceOfPie;
import org.pieshare.service.core.IDirectoryService;

/**
 *
 * @author richy
 */
public class FolderContentReader implements IFolderContentReader
{

	private IDirectoryService directoryService;

	public void setFileAnalyzer()
	{
	}

	public void setDirectoryService(IDirectoryService directoryService)
	{
		this.directoryService = directoryService;
	}

	@Override
	public List<PieceOfPie> getFolderContent()
	{
		File wokkingDirectory = directoryService.getCurrentCookingDirectory();
		return recusriveFileSearch(wokkingDirectory);
	}

	private List<PieceOfPie> recusriveFileSearch(File folder)
	{
		List<PieceOfPie> pieList = new ArrayList<>();
		

		for (File f : folder.listFiles())
		{
			if (f.isDirectory())
			{
				pieList.addAll(recusriveFileSearch(f));
			}
			else
			{
				pieList.add(new PieceOfPie(f));
			}
		}
		
		return pieList;
	}
}
