/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.filewatcher;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import junit.framework.Assert;
import org.junit.After;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.pieshare.service.core.PieLogger;
import org.pieshare.service.event.EventCallback;
import org.pieshare.service.filewatcher.FileWatcherEvent;
import org.pieshare.service.filewatcher.FileWatcherService;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import org.pieshare.domain.PieceOfPie;
import org.pieshare.service.event.EventBaseService;
import org.pieshare.service.filewatcher.IFileWatcherService;

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

	Assert.fail("Not implemented");
		
		String testPath = "../";
		ExecutorService executorService = Executors.newCachedThreadPool();

		EventBaseService mockedEventBaseServie = Mockito.mock(EventBaseService.class);
		
		Mockito.doAnswer(new Answer()
		{
			@Override
			public Object answer(InvocationOnMock invocation) throws Throwable
			{
				fileWatcherListener();
				return null;
			}
		}).when(mockedEventBaseServie).fireEvent(FileWatcherEvent.class, Mockito.anyObject(), Mockito.anyCollection().toArray());

		FileWatcherService fileWatcher = new FileWatcherService();
		fileWatcher.setDirectory(testPath);
		//fileWatcher.addFileChangeEventListener(this);
		fileWatcher.setEventBaseService(mockedEventBaseServie);

		executorService.execute(fileWatcher);

		File f1 = new File(testPath, ".testFile");

		if (!f1.exists())
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

		assertEquals(1, eventCount);

		//Stopps repeating the filewatcher after next interation.
		fileWatcher.stopRunning();

		f1.delete();

		assertEquals(2, eventCount);

		assertEquals(f1.exists(), false);

	}

	@EventCallback(eventClass = FileWatcherEvent.class)
	public void fileWatcherListener()
	{
		eventCount++;
	}
}
