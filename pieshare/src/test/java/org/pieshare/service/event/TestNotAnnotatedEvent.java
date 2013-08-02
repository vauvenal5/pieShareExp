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
public class TestNotAnnotatedEvent extends EventObject
{
	public TestNotAnnotatedEvent(Object sender)
	{
		super(sender);
	}
}
