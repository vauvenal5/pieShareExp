/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.core.filehashgenerator;

import java.io.File;

/**
 *
 * @author richy
 */
public interface IFileHashGenerator
{
	String getMD5ChecksumHex(File file) throws FileHashGeneratorException;
	byte[] getMD5ChecksumByte(File file) throws FileHashGeneratorException;
}
