/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieshare;

import org.pieshare.commandParser.ICommandParserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author richy
 */
public class PieShareController
{

	private IPieService pieService;
	private ICommandParserService parserService;

	public void setPieService(IPieService service)
	{
		this.pieService = service;
	}
	
	public boolean restartAsServer()
	{
		return !this.pieService.isPieShareRunning();
	}
	
	private void parseArgs(String[] args)
	{
		try
		{
			parserService.parseArgs(args);
		}
		catch (Exception ex)
		{
			ex.printStackTrace();
		}
	}

	public void start(String[] args)
	{
		if(this.restartAsServer())
		{
			return;
		}

		//send command via pieception and exit
		this.parseArgs(args);
	}

	public void startServer(String[] args)
	{
		//startup server
		this.parseArgs(args);
	}

	public void setApplicationContext(ApplicationContext context)
	{
		this.pieService.setApplicationContext(context);
	}

	public static void main(String[] args)
	{
		//todo checkout apache shiro
		ApplicationContext context = new ClassPathXmlApplicationContext("application-context.xml");
		PieShareController controller = (PieShareController) context.getBean("pieShareController");
		controller.setApplicationContext(context);
		controller.start(args);
		
		if(controller.restartAsServer())
		{
			context = new ClassPathXmlApplicationContext("application-context-server.xml");
			controller = (PieShareController) context.getBean("pieShareController");
			controller.setApplicationContext(context);
			controller.startServer(args);
		}
	}
}
