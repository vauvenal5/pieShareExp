/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieshare;

/**
 *
 * @author vauve_000
 */
public interface IPieService 
{
	boolean isPieShareRunning();
	
	void executeService(Runnable service);
	
	String getPieceptionBindingName();
	
	String getPieceptionRegistryHost();
	
	int getPieceptionRegistryPort();
	
	<T> T getBean(Class<T> type);
}
