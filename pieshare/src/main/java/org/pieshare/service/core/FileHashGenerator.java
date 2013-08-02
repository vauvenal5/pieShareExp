/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.core;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.security.MessageDigest;

/**
 *
 * @author richy
 */
public class FileHashGenerator implements IFileHashGenerator
{
	private String algo = "MD5";
	
	private byte[] createChecksum(File file) throws Exception
	{
		InputStream fis = new FileInputStream(file);

		byte[] buffer = new byte[1024];
		MessageDigest complete = MessageDigest.getInstance(algo);
		int numRead;

		do
		{
			numRead = fis.read(buffer);
			if (numRead > 0)
			{
				complete.update(buffer, 0, numRead);
			}
		}
		while (numRead != -1);

		fis.close();
		return complete.digest();
	}

	// see this How-to for a faster way to convert
	// a byte array to a HEX string
	@Override
	public String getMD5ChecksumHex(File file) throws Exception
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
	public byte[] getMD5ChecksumByte(File file) throws Exception
	{
		return createChecksum(file);
	}
}
