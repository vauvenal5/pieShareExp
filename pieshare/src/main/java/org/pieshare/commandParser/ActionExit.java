/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.commandParser;

import java.util.Map;
import org.pieshare.pieception.IPieceptionService;

/**
 *
 * @author vauvenal5
 */
public class ActionExit extends ActionBase
{
	@Override
	public void doAction(Map<String, Object> args)
	{
		this.pieceptionService.getCommandService().exit();
	}
}
