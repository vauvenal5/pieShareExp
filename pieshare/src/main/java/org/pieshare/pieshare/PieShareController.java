/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieshare;

import org.pieshare.filewatcher.IFileWatcherService;
import org.pieshare.pieception.PieceptionController;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author richy
 */
public class PieShareController
{

	private IPieService pieService;
	//protected ExecutorService executorService = Executors.newCachedThreadPool(); now in pieService!!!

	public void setPieService(IPieService service)
	{
		this.pieService = service;
	}

	public void start(String[] args)
	{
		PieceptionController controller = (PieceptionController) pieService.getBean(PieceptionController.class);
		pieService.shutdown();
		//TestConnection k = new TestConnection();
		//k.getCon();

		//TestDao testDao = (TestDao)context.getBean("testDao"); //pieService is context aware!!! see pieService

		/*if(pieService.isPieShareRunning())
		 {
		 //start client command mode do command and exit
		 System.exit(0);
		 }*/

		//ToDoSv: check DB for PID and start Client or Server mode
		//ToDoSv: write PID to DB
		//IMPORTANT: allow startup of other then the PieceptionController only if PieceptionController gives the okay!!!

		//FileWatcher watcher = new FileWatcher();

		//executorService.execute(watcher);
	}

	public void startServer(String[] args)
	{
	}

	public void setApplicationContext(ApplicationContext context)
	{
		this.pieService.setApplicationContext(context);
	}

	private static void restart(String[] args)
	{
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context-server.xml");
		PieShareController controller = (PieShareController) context.getBean("pieShareController");
		controller.setApplicationContext(context);
		controller.startServer(args);
	}

	public static void main(String[] args)
	{
		//todo checkout Argparse4j
		//todo checkout apache shiro

		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		PieShareController controller = (PieShareController) context.getBean("pieShareController");
		controller.setApplicationContext(context);
		controller.start(args);
	}
}
