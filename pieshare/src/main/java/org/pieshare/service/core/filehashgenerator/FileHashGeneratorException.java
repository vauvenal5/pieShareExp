/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.core.filehashgenerator;

import org.pieshare.service.event.*;

/**
 *
 * @author vauve_000
 */
public class FileHashGeneratorException extends Exception
{
	/**
	 * Constructs an instance of
	 * <code>FileHashGeneratorException</code> with the specified detail message.
	 *
	 * @param msg the detail message.
	 */
	public FileHashGeneratorException(String msg)
	{
		super(msg);
	}
	
/**	
	 * Constructs an instance of
	 * <code>FileHashGeneratorException</code> with the specified detail message and the cause of the exception.
	 *
	 * @param msg the detail message.
	 * @param cause the cause of this exception
	 */
	public FileHashGeneratorException(String msg, Throwable cause)
	{
		super(msg, cause);
	}
}
