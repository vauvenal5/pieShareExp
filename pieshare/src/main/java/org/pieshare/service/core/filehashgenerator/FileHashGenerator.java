/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.core.filehashgenerator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author richy
 */
public class FileHashGenerator implements IFileHashGenerator
{
	private String algo = "MD5";
	
	private byte[] createChecksum(File file) throws FileHashGeneratorException
	{
		InputStream fis;
		try
		{
			fis = new FileInputStream(file);
		}
		catch (FileNotFoundException ex)
		{
			throw  new FileHashGeneratorException("File not found in createHash function", ex.getCause());
		}

		byte[] buffer = new byte[1024];
		
		MessageDigest complete;
		
		try
		{
			complete = MessageDigest.getInstance(algo);
		}
		catch (NoSuchAlgorithmException ex)
		{
			throw  new FileHashGeneratorException("No hash algorithm " + algo + " known", ex.getCause());
		}
		
		int numRead = -1;

		do
		{
			try
			{
				numRead = fis.read(buffer);
			}
			catch (IOException ex)
			{
				throw  new FileHashGeneratorException("IO Exception while reading file", ex.getCause());
			}
			
			if (numRead > 0)
			{
				complete.update(buffer, 0, numRead);
			}
		}
		while (numRead != -1);
		
		try
		{
			fis.close();
		}
		catch (IOException ex)
		{
				throw  new FileHashGeneratorException("IO Exception at file closing", ex.getCause());
		}
		
		
		
		return complete.digest();
	}

	// see this How-to for a faster way to convert
	// a byte array to a HEX string
	@Override
	public String getMD5ChecksumHex(File file) throws FileHashGeneratorException
	{
		byte[] b = createChecksum(file);
		String result = "";

		for (int i = 0; i < b.length; i++)
		{
			result += Integer.toString((b[i] & 0xff) + 0x100, 16).substring(1);
		}
		return result;
	}
	
	// see this How-to for a faster way to convert
	// a byte array to a HEX string
	@Override
	public byte[] getMD5ChecksumByte(File file) throws FileHashGeneratorException
	{
		return createChecksum(file);
	}
}
