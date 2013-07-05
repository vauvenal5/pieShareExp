/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.exceptions;

/**
 *
 * @author vauve_000
 */
public class NoCallbackPointException extends Exception
{

	/**
	 * Creates a new instance of
	 * <code>NoCallbackPointException</code> without detail message.
	 */
	public NoCallbackPointException()
	{
	}

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
