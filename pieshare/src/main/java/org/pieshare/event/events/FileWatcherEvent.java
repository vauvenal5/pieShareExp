/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.event.events;

import java.util.EventObject;
import org.pieshare.common.PieceOfPie;

/**
 *
 * @author richy
 */
public class FileWatcherEvent extends EventObject
{
	private PieceOfPie piePiece;
	
	public FileWatcherEvent(Object source, PieceOfPie piePiece)
	{
		super(source);
		this.piePiece = piePiece;
	}

	public PieceOfPie getPiePiece()
	{
		return piePiece;
	}	
}
