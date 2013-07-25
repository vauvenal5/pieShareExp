/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.event;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.mockito.Mockito;

/**
 *
 * @author vauve_000
 */
public class TestEventBaseService
{	
	public TestEventBaseService()
	{
	}
	
	@Before
	public void setUp()
	{
	}
	
	@After
	public void tearDown()
	{
	}
	
	@Test
	public void TestRemoveEventListener() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException
	{
		EventBaseService ebs = new EventBaseService();
		
		Field privateField = EventBaseService.class.getDeclaredField("listenerList");
		privateField.setAccessible(true);
		
		HashMap<Class, List<Object>> map = (HashMap<Class, List<Object>>)privateField.get(ebs);
		List<Object> eventList = new ArrayList<Object>();
		eventList.add(this);
		map.put(TestEvent.class, eventList);
			
		ebs.removeEventListener(TestEvent.class, this);
		
		Assert.assertEquals(0, map.get(TestEvent.class).size());
	}
	
	@Test
	@EventCallback(eventClass=TestEvent.class)
	public void TestAddEventListener() throws NoCallbackPointException, NoSuchFieldException, IllegalArgumentException, IllegalAccessException
	{
		EventBaseService ebs = new EventBaseService();
		
		ebs.addEventListener(TestEvent.class, this);
		ebs.addEventListener(TestEvent.class, this);
		
		Field privateField = EventBaseService.class.getDeclaredField("listenerList");
		privateField.setAccessible(true);
		
		HashMap<Class, List<Object>> map = (HashMap<Class, List<Object>>)privateField.get(ebs);
		
		Assert.assertEquals(2, map.get(TestEvent.class).size());
	}
	
	@Test(expected = NoCallbackPointException.class)
	public void TestAddEventListenerWithoutAnnotation() throws NoCallbackPointException
	{
		EventBaseService ebs = new EventBaseService();
		
		ebs.addEventListener(TestNotAnnotatedEvent.class, this);
		
		Assert.fail();
	}
}
