/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.filewatcher;

import javax.swing.event.EventListenerList;
import javax.xml.bind.Marshaller;

/**
 *
 * @author richy
 */
public class FileWatcher implements Runnable
{

	private EventListenerList eventList = new EventListenerList();

	public void run()
	{
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
			
		}

	}
}