/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.filewatcher;
import java.io.File;
import java.io.IOException;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.pieshare.service.core.PieLogger;
import org.pieshare.service.event.EventCallback;
import org.pieshare.service.filewatcher.FileWatcherEvent;
import org.pieshare.service.filewatcher.FileWatcherService;
import org.mockito.Mockito;

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
	
	
	
	public void testFileWatcher()
	{
			
		String testPath = "../";
		
		FileWatcherService fileWatcher = new FileWatcherService();
		fileWatcher.setDirectory(testPath);
		fileWatcher.addFileChangeEventListener(this);
		
		fileWatcher.run();
		
		File f1 = new File(testPath, ".testFile");
		
		if(!f1.exists())
		{
			try
			{
				f1.createNewFile();
			}
			catch (IOException ex)
			{
				PieLogger.error(this.getClass(), "Error creating new File during test fileWatcher");
				assertFalse(true);
			}
		}
		
		assertEquals(eventCount, 1);
		
		//Stopps repeating the filewatcher after next interation.
		fileWatcher.stopRunning();
		
		f1.delete();
		
		assertEquals(eventCount, 2);
		
		assertEquals(f1.exists(), false);
		
	}
	
	@EventCallback(eventClass = FileWatcherEvent.class)
	public void fileWatcherListener()
	{
		eventCount++;
	}
}
