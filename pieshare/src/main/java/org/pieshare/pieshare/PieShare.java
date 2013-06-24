/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieshare;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.sql.DataSource;
import org.pieshare.dao.TestConnection;
import org.pieshare.dao.TestDao;
import org.pieshare.filewatcher.FileWatcher;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author richy
 */
public class PieShare
{

	protected ExecutorService executorService = Executors.newCachedThreadPool();

	
	public void start()
	{
		
		//TestConnection k = new TestConnection();
		//k.getCon();
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		
		TestDao testDao = (TestDao)context.getBean("testDao");
		
		
		
		//FileWatcher watcher = new FileWatcher();
		
		//executorService.execute(watcher);
	}
	
	public static void main(String[] args)
	{
		PieShare pie = new PieShare();
		pie.start();
	}
}
