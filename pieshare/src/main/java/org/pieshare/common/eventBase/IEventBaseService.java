/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.common.eventBase;

import java.util.EventListener;

/**
 *
 * @author vauve_000
 */
public interface IEventBaseService 
{
	public void addEventListener(Class eventClass, EventListener listener);
	public void removeShutdownEventListener(Class eventClass, EventListener listener);
	public void fireEvent(Class eventClass, Object source);
}
