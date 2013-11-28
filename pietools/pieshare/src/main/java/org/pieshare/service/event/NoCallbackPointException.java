/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.event;

/**
 *
 * @author vauve_000
 */
public class NoCallbackPointException extends Exception
{
	/**
	 * Constructs an instance of
	 * <code>NoCallbackPointException</code> with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public NoCallbackPointException(String msg)
	{
		super(msg);
	}
}
