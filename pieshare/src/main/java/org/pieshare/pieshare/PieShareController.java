/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieshare;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.pieshare.dao.TestDao;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author richy
 */
public class PieShareController
{
	private IPieService pieService;
	//protected ExecutorService executorService = Executors.newCachedThreadPool();
	
	public void setPieService(IPieService service)
	{
		this.pieService = service;
	}
	
	public void start()
	{
		
		
		//TestConnection k = new TestConnection();
		//k.getCon();
		
		//TestDao testDao = (TestDao)context.getBean("testDao");
		
		if(pieService.isPieShareRunning())
		{
			//start client command mode do command and exit
			System.exit(0);
		}
		
		//ToDoSv: check DB for PID and start Client or Server mode
		//ToDoSv: write PID to DB
		//IMPORTANT: allow startup of other then the PieceptionController only if PieceptionController gives the okay!!!
		
		//FileWatcher watcher = new FileWatcher();
		
		//executorService.execute(watcher);
	}
	
	public static void main(String[] args)
	{
		//todo checkout Argparse4j
		
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");        
        PieShareController controller = (PieShareController) context.getBean("appController");        
        controller.start();
	}
}
