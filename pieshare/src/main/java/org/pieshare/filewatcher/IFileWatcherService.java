/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.filewatcher;

import org.pieshare.event.eventBase.IEventBaseService;
import org.pieshare.event.supported.ISupportFileWatcherEvent;

/**
 *
 * @author richy
 */
public interface IFileWatcherService extends Runnable, ISupportFileWatcherEvent
{

	void setEventBaseService(IEventBaseService eventBaseService);
}
