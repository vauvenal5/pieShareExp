/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.filewatcher;

import org.pieshare.service.event.IEventBaseService;

/**
 *
 * @author richy
 */
public interface IFileWatcherService extends Runnable, ISupportFileWatcherEvent
{

	void setEventBaseService(IEventBaseService eventBaseService);
}
