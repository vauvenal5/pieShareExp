/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package PieShare;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.pieshare.filewatcher.FileWatcher;

/**
 *
 * @author richy
 */
public class PieShare
{

	protected ExecutorService executorService = Executors.newCachedThreadPool();

	
	public void start()
	{
		FileWatcher watcher = new FileWatcher();
		
		executorService.execute(watcher);
	}
	
	public static void main(String[] args)
	{
		PieShare pie = new PieShare();
		pie.start();
	}
}
