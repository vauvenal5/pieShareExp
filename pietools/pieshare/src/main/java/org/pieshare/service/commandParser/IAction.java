/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.commandParser;

import java.util.Map;

/**
 *
 * @author vauvenal5
 */
public interface IAction
{

	public void doAction(Map<String, Object> args);
}
