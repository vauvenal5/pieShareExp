/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.domain;

import org.pieshare.service.event.*;

/**
 *
 * @author vauve_000
 */
public class NoEntityException extends Exception
{
	/**
	 * Constructs an instance of
	 * <code>NoEntityException</code> with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public NoEntityException(String msg)
	{
		super(msg);
	}
}
