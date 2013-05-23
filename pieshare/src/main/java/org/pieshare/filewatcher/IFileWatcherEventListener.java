/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.filewatcher;

import java.util.EventListener;
import org.pieshare.common.PieceOfPie;

/**
 *
 * @author richy
 */
public interface IFileWatcherEventListener extends EventListener
{
	public void fileChanged(PieceOfPie piePiece);
	
}
