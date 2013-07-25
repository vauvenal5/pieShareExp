/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.filewatcher;

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
import org.pieshare.domain.PieceOfPie;
import org.pieshare.service.event.IEventBaseService;

/**
 *
 * @author Richard Leopold
 */
public class FileWatcherService implements IFileWatcherService
{

	private static final Logger logger = Logger.getLogger(FileWatcherService.class);
	private IEventBaseService eventBaseService;

	@Override
	public void setEventBaseService(IEventBaseService eventBaseService)
	{
		this.eventBaseService = eventBaseService;
	}

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
			return;
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
			// wait for key to be signaled
			try
			{
				key = watcher.take();
			}
			catch (InterruptedException x)
			{
				return;
			}

			for (WatchEvent<?> event : key.pollEvents())
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

				eventBaseService.fireEvent(FileWatcherEvent.class, this, new PieceOfPie(filename.toFile(), kind));

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

	@Override
	public void addFileChangeEventListener(Object listener)
	{
		eventBaseService.addEventListener(FileWatcherEvent.class, listener);
	}

	@Override
	public void removeFileChangeEventListener(Object listener)
	{
		eventBaseService.removeShutdownEventListener(FileWatcherEvent.class, listener);
	}
}