/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.filewatcher;

import org.pieshare.event.events.FileWatcherEvent;
import java.io.File;
import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import static java.nio.file.StandardWatchEventKinds.*;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;


import javax.swing.event.EventListenerList;
import org.apache.log4j.Logger;
import org.pieshare.common.PieceOfPie;

/**
 *
 * @author Richard Leopold
 */
public class FileWatcher implements Runnable, IFileWatcher
{

	private static final Logger logger = Logger.getLogger(FileWatcher.class);
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
			logger.debug("Not possible to set up watcher. Err: " + ex.getMessage());
		}

		//ToDo: Decide from where the Path is comming. 

		File file = new File("../");
		Path dir = file.toPath();

		WatchKey key = null;

		try
		{
			key = dir.register(watcher, ENTRY_CREATE, ENTRY_DELETE, ENTRY_MODIFY);
		}
		catch (IOException ex)
		{
			logger.debug("Not possible register watcher on directory/file. Err: " + ex.getMessage());
			return;
		}

		for (;;)
		{
			try
			{
				Thread.sleep(3000);
			}
			catch (InterruptedException ex)
			{
				logger.debug("Error thread sleep. Err: " + ex.getMessage());
				return;
			}

			List<WatchEvent<?>> events = key.pollEvents();

			if (events != null)
			{

				for (WatchEvent<?> event : events)
				{
					WatchEvent.Kind<?> kind = event.kind();

					// This key is registered only
					// for ENTRY_CREATE events,
					// but an OVERFLOW event can
					// occur regardless if events
					// are lost or discarded.
					if (kind == OVERFLOW)
					{
						continue;
					}

					// The filename is the
					// context of the event.
					WatchEvent<Path> ev = (WatchEvent<Path>) event;
					Path filename = ev.context();

					fireChangeEvent(new PieceOfPie(filename.toFile(), kind));
				}

				// Reset the key -- this step is critical if you want to
				// receive further watch events.  If the key is no longer valid,
				// the directory is inaccessible so exit the loop.
				boolean valid = key.reset();
				if (!valid)
				{
					break;
				}
			}
		}

	}

	@Override
	public void addFileChangeEventListener(IFileWatcherEventListener listener)
	{
		eventList.add(IFileWatcherEventListener.class, listener);
	}

	@Override
	public void removeFileChangeEventListener(IFileWatcherEventListener listener)
	{
		eventList.remove(IFileWatcherEventListener.class, listener);
	}

	@Override
	public void fireChangeEvent(PieceOfPie pieceOfPie)
	{
		Object[] listeners = eventList.getListenerList();

		for (Object o : listeners)
		{
			((IFileWatcherEventListener) o).fileChanged(new FileWatcherEvent(this, pieceOfPie));
		}
	}
}