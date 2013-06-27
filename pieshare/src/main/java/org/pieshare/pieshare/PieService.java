/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieshare;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author vauve_000
 */
public class PieService implements IPieService, ApplicationContextAware
{
	private ExecutorService executorService;
	private IPieDao pieDao;
	private ApplicationContext context;
	
	public PieService()
	{
		this.executorService = Executors.newCachedThreadPool();
	}

	@Override
	public boolean isPieShareRunning() 
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void executeService(Runnable service) 
	{
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
	public void setApplicationContext(ApplicationContext ac) 
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
	
}
