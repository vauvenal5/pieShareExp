/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieshare;

import org.pieshare.common.IRunnable;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author vauve_000
 */
public interface IPieService extends ApplicationContextAware
{
	boolean isPieShareRunning();
	
	void executeService(IRunnable service);
	
	String getPieceptionBindingName();
	
	String getPieceptionRegistryHost();
	
	int getPieceptionRegistryPort();
	
	<T> T getBean(Class<T> type);
	
	void shutdown();
}
