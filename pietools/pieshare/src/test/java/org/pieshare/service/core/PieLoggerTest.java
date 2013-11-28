/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.core;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author richy
 */
public class PieLoggerTest
{
	
	public PieLoggerTest()
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
	}
	
	@After
	public void tearDown()
	{
	}

	/**
	 * Test of debug method, of class PieLogger.
	 */
	@Test
	public void testDebug()
	{
		System.out.println("debug");
		Class clazz = this.getClass();
		String message = "This is a test debug messege";
		PieLogger.debug(clazz, message);
		assertTrue(true);
	}
}