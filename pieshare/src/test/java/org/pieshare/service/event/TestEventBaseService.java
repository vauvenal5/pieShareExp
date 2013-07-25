/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.event;

import junit.framework.Assert;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author vauve_000
 */
public class TestEventBaseService
{
	private boolean testing;
	private boolean fail;
	
	public TestEventBaseService()
	{
	}
	
	@BeforeClass
	public static void setUpClass()
	{
	}
	
	@AfterClass
	public static void tearDownClass()
	{
	}
	
	@Before
	public void setUp()
	{
		this.testing = false;
		this.fail = false;
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
	@EventCallback(eventClass = TestRemoveEventListenerEvent.class)
	public void TestRemoveEventListener()
	{
		if(this.testing)
		{
			this.fail = true;
			return;
		}
		
		EventBaseService ebs = new EventBaseService();
		ebs.addEventListener(TestRemoveEventListenerEvent.class, this);
		ebs.removeShutdownEventListener(TestRemoveEventListenerEvent.class, this);
		ebs.fireEvent(TestRemoveEventListenerEvent.class, this);
		
		Assert.assertFalse(this.fail);
	}
}
