/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.core;

import java.util.EventListener;
import org.pieshare.service.core.ISupportShutdownEvent;
import org.springframework.context.ApplicationContextAware;

/**
 *
 * @author vauve_000
 */
public interface IPieService extends ApplicationContextAware, ISupportShutdownEvent
{

	boolean isPieShareRunning();

	void executeService(Runnable service);

	String getPieceptionBindingName();

	String getPieceptionRegistryHost();

	int getPieceptionRegistryPort();

	<T> T getBean(Class<T> type);

	void shutdown();
        
        void setPieShareIsRunning();
}
