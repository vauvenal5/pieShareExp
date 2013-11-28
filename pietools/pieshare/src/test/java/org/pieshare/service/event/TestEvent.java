/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.event;

import java.util.EventObject;

/**
 *
 * @author vauve_000
 */ 
public class TestEvent extends EventObject
{
	public TestEvent(String msg)
	{
		super(msg);
	}
}
