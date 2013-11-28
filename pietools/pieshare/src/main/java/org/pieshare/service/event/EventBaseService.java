/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.event;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.EventListener;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vauve_000
 */
public class EventBaseService implements IEventBaseService
{

	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(EventBaseService.class);
	private HashMap<Class, List<Object>> listenerList = new HashMap<>();

	private boolean checkForAnnotation(Class eventClass, Class listenerClass)
	{
		for (Method m : listenerClass.getMethods())
		{
			if (m.isAnnotationPresent(EventCallback.class))
			{
				if (m.getAnnotation(EventCallback.class).eventClass() == eventClass)
				{
					return true;
				}
			}
		}

		return false;
	}
	
	@Override
	public void addEventListener(Class eventClass, Object listener) throws NoCallbackPointException
	{
		if (!checkForAnnotation(eventClass, listener.getClass()))
		{
			throw new NoCallbackPointException("No callback point for event!");
		}

		if (this.listenerList.containsKey(eventClass))
		{
			this.listenerList.get(eventClass).add(listener);
			return;
		}

		List<Object> list = new ArrayList<>();
		list.add(listener);

		this.listenerList.put(eventClass, list);
	}

	@Override
	public void removeEventListener(Class eventClass, Object listener)
	{
		if (this.listenerList.containsKey(eventClass))
		{
			this.listenerList.get(eventClass).remove(listener);
		}
	}

	@Override
	public void fireEvent(Class eventClass, Object source, Object... args)
	{
		List<Object> listeners = this.listenerList.get(eventClass);

		if (listeners == null)
		{
			return;
		}

		for (Object l : listeners)
		{
			for (Method m : l.getClass().getMethods())
			{
				if (m.isAnnotationPresent(EventCallback.class))
				{
					EventCallback a = m.getAnnotation(EventCallback.class);

					if (a.eventClass() == eventClass)
					{
						try
						{
							if (a.sourceClass() != Class.class)
							{
								//invoke handler which wants the source object
								for (Constructor c : eventClass.getConstructors())
								{
									if (c.getParameterTypes().length == args.length + 1)
									{
										m.invoke(l, c.newInstance(source, args));
									}
								}
							}
							else
							{
								//invoke empty handler
								m.invoke(l);
							}
							break;
						}
						catch (InstantiationException ex)
						{
							Logger.getLogger(EventBaseService.class.getName()).log(Level.SEVERE, null, ex);
						}
						catch (IllegalAccessException | IllegalArgumentException ex)
						{
							logger.debug("Event management failed! Err: " + ex.getMessage());
						}
						catch (InvocationTargetException ex)
						{
							logger.debug("Event management failed! Err: " + ex.getTargetException().getMessage());
						}
					}
				}
			}
		}
	}
}
