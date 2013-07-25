/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.core;

import java.util.EventObject;

/**
 *
 * @author vauve_000
 */
public class ShutdownEvent extends EventObject
{

	public ShutdownEvent(Object source)
	{
		super(source);
	}
}
