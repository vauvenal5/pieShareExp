/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieshare;

import java.util.EventListener;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.pieshare.event.eventBase.IEventBaseService;
import org.pieshare.event.events.ShutdownEvent;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 *
 * @author vauve_000
 */
public class PieService implements IPieService
{
	private ExecutorService executorService;
	private IPieDao pieDao;
	private ApplicationContext context;
	private IEventBaseService eventBaseService;
	
	public PieService()
	{
		this.executorService = Executors.newCachedThreadPool();
	}

	@Override
	public boolean isPieShareRunning() 
	{
		return false;
	}

	@Override
	public void executeService(Runnable service) 
	{
		this.addShutdownEventListener(service);
		this.executorService.execute(service);
	}

	@Override
	public String getPieceptionBindingName() 
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public <T> T getBean(Class<T> type) 
	{
		return context.getBean(type);
	}

	@Override
	public void setApplicationContext(ApplicationContext context) 
	{
		this.context = context;
	}

	@Override
	public String getPieceptionRegistryHost() 
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public int getPieceptionRegistryPort() 
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void shutdown() 
	{
		this.eventBaseService.fireEvent(ShutdownEvent.class, this);
	}
	
	public void setEventBaseService(IEventBaseService service)
	{
		this.eventBaseService = service;
	}

	@Override
	public void addShutdownEventListener(Object listener) 
	{
		this.eventBaseService.addEventListener(ShutdownEvent.class, listener);
	}

	@Override
	public void removeShutdownEventListener(Object listener) 
	{
		this.eventBaseService.removeShutdownEventListener(ShutdownEvent.class, listener);
	}
}
