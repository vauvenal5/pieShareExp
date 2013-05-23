/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.filewatcher;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.logging.Level;
import java.util.logging.Logger;


import javax.swing.event.EventListenerList;

/**
 *
 * @author richy
 */
public class FileWatcher implements Runnable
{

	private EventListenerList eventList = new EventListenerList();

	@Override
	public void run()
	{
		WatchService watcher = null;
		
		try
		{
			watcher = FileSystems.getDefault().newWatchService();
		}
		catch (IOException ex)
		{
			Logger.getLogger(FileWatcher.class.getName()).log(Level.SEVERE, null, ex);
		}
		
		//ToDo: Decide from where the Path is comming. 
		Path dir = new File("../..)").toPath();
		
		WatchKey key = null;
		
		try
		{
			key = dir.register(watcher, ENTRY_CREATE,ENTRY_DELETE, ENTRY_MODIFY);
		}
		catch (IOException x)
		{
			System.err.println(x);
		}
		
		
		
		
		
		
	}

	public void addFileChangeEventListener(IFileWatcherEventListener listener)
	{
		eventList.add(IFileWatcherEventListener.class, listener);
	}

	public void removeFileChangeEventListener(IFileWatcherEventListener listener)
	{
		eventList.remove(IFileWatcherEventListener.class, listener);
	}

	public void fireChangeEvent()
	{
		Object[] listeners = eventList.getListenerList();



		for (Object o : listeners)
		{

			//ToDo: add the Piece of Pie instead null

			((IFileWatcherEventListener) o).fileChanged(new FileWatcherEvent(null, this));
		}

	}
}