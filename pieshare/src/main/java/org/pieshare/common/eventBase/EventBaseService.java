/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.common.eventBase;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author vauve_000
 */
public class EventBaseService implements IEventBaseService
{
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EventBaseService.class);
	private HashMap<Class, List<EventListener>> listenerList = new HashMap<>();
	
	@Override
	public void addEventListener(Class eventClass, EventListener listener)
	{
		if(this.listenerList.containsKey(eventClass))
		{
			this.listenerList.get(eventClass).add(listener);
			return;
		}
		
		List<EventListener> list = new ArrayList<>();
		list.add(listener);
		
		this.listenerList.put(eventClass, list);
	}
	
	@Override
	public void removeShutdownEventListener(Class eventClass, EventListener listener)
	{
		if(this.listenerList.containsKey(eventClass))
		{
			this.listenerList.get(eventClass).remove(listener);
		}
	}
	
	@Override
	public void fireEvent(Class eventClass, Object source)
	{
		List<EventListener> listeners = this.listenerList.get(eventClass);
		
		if(listeners == null)
		{
			return;
		}
		
		for(EventListener l: listeners)
		{
			for(Method m: l.getClass().getMethods())
			{
				if(m.isAnnotationPresent(EventCallback.class))
				{
					EventCallback a = m.getAnnotation(EventCallback.class);
					
					if(a.eventClass() == eventClass)
					{
						try 
						{
							if(a.sourceClass() != Class.class)
							{
								//invoke handler which wants the source object
								m.invoke(l, a.sourceClass().cast(source));
								break;
							}
							
							//invoke empty handler
							
							m.invoke(l);
							break;
						} 
						catch (IllegalAccessException | IllegalArgumentException ex) 
						{
							logger.debug("Event management failed! Err: " + ex.getMessage());
						}
						catch(InvocationTargetException ex)
						{
							logger.debug("Event management failed! Err: " + ex.getTargetException().getMessage());
						}
					}
				}
			}
		}
	}
}
