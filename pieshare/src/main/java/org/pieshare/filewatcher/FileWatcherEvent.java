/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.filewatcher;

import org.pieshare.common.PieceOfPie;

/**
 *
 * @author richy
 */
public class FileWatcherEvent
{
	private PieceOfPie piePiece;
	private Object source;
	
	public FileWatcherEvent(PieceOfPie piePiece, Object source)
	{
		this.piePiece = piePiece;
		this.source = source;
	}

	public PieceOfPie getPiePiece()
	{
		return piePiece;
	}

	public Object getSource()
	{
		return source;
	}
	
	
}
