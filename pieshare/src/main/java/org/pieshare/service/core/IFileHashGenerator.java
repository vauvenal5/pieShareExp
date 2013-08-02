/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.core;

import java.io.File;

/**
 *
 * @author richy
 */
public interface IFileHashGenerator
{
	String getMD5ChecksumHex(File file) throws Exception;
	byte[] getMD5ChecksumByte(File file) throws Exception;
}
