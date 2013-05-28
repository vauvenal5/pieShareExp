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
public interface IFileWatcher
{
	public void addFileChangeEventListener(IFileWatcherEventListener listener);
	public void removeFileChangeEventListener(IFileWatcherEventListener listener);
	public void fireChangeEvent(PieceOfPie pieceOfPie);
}
