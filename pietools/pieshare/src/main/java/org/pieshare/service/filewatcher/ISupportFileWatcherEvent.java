/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.filewatcher;

import org.pieshare.service.filewatcher.IFileWatcherEventListener;

/**
 *
 * @author vauve_000
 */
public interface ISupportFileWatcherEvent
{

	public void addFileChangeEventListener(Object listener);

	public void removeFileChangeEventListener(Object listener);
}
