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
public interface IDirectoryService
{

	/*
	 * Return the user Direcotry from the actual OS
	 *
	 * @return User directory as File
	 */
	File getOSUserDirectory();

	/*
	 * Returns the ".pieshare" folder which is located in the OS user direcotry
	 *
	 * @return PieShare folder as File
	 */
	File getTempPieShareDirectory();
	
	/*
	 * Returns the actual working directory where the files to sync. are located
	 *
	 * @return Working folder as File
	 */
	File getCurrentCookingDirectory();
}
