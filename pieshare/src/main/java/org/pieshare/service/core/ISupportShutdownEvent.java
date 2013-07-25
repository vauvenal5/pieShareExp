/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.core;

import java.util.EventListener;

/**
 *
 * @author vauve_000
 */
public interface ISupportShutdownEvent
{

	void addShutdownEventListener(Object listener);

	void removeShutdownEventListener(Object listener);
}
