/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.filewatcher;

import java.util.EventObject;
import org.pieshare.domain.PieceOfPie;

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
