/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.filewatcher;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.pieshare.event.eventBase.EventCallback;
import org.pieshare.event.events.FileWatcherEvent;

/**
 *
 * @author richy
 */
public class TestFileWatcher
{
	private int eventCount = 0;
	
	@Before
	public void startUp()
	{
	
	}
	
	@After
	public void cleanUp()
	{
	
	}
	
	
	@Test
	public void testFileWatcher()
	{
		FileWatcherService fileWatcher = new FileWatcherService();
		fileWatcher.setDirectory("../");
		fileWatcher.addFileChangeEventListener(this);
		
		fileWatcher.run();
		
		
		
	}
	
	@EventCallback(eventClass = FileWatcherEvent.class)
	public void fileWatcherListener()
	{
	
	}
}
