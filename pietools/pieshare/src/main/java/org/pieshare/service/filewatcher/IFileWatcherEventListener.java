/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.filewatcher;

import java.util.EventListener;

/**
 *
 * @author richy
 */
public interface IFileWatcherEventListener extends EventListener
{

	public void fileChanged(FileWatcherEvent event);
}
