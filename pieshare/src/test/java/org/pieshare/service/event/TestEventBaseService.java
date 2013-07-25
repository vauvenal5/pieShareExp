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
	// TODO add test methods here.
	// The methods must be annotated with annotation @Test. For example:
	//
	// @Test
	// public void hello() {}
	
	@Test
	public void TestRemoveEventListener() throws IllegalArgumentException, IllegalAccessException, NoSuchFieldException
	{
		EventBaseService ebs = new EventBaseService();
		
		Field privateField = EventBaseService.class.getDeclaredField("listenerList");
		privateField.setAccessible(true);
		privateField.get(ebs);
		
		HashMap<Class, List<Object>> map = (HashMap<Class, List<Object>>)privateField.get(ebs);
		List<Object> eventList = new ArrayList<Object>();
		eventList.add(this);
		map.put(TestRemoveEventListenerEvent.class, eventList);
			
		ebs.removeEventListener(TestRemoveEventListenerEvent.class, this);
		
		Assert.assertEquals(0, map.get(TestRemoveEventListenerEvent.class).size());
	}
}
