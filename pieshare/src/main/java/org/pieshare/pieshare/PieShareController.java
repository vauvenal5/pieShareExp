/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieshare;

import org.pieshare.commandParser.ICommandParserService;
import org.pieshare.common.PieObject;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author richy
 */
public class PieShareController extends PieObject
{
	private IPieService pieService;
	private ICommandParserService parserService;

	public void setPieService(IPieService service)
	{
		this.pieService = service;
	}

	public void setCommandParserService(ICommandParserService service)
	{
		this.parserService = service;
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
		this.logger.info("Starting application as command client!");
		//send command via pieception and exit
		this.parseArgs(args);
		
		if (this.restartAsServer())
		{
			this.logger.info("No running instance detected! Restarting as server!");
			return;
		}
	}

	public void startServer(String[] args)
	{
		this.logger.info("Starting application as command server!");
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

		if (controller.restartAsServer())
		{
			context = new ClassPathXmlApplicationContext("application-context-server.xml");
			controller = (PieShareController) context.getBean("pieShareController");
			controller.setApplicationContext(context);
			controller.startServer(args);
		}
	}
}
