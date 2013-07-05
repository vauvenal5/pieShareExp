/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.commandParser;

import org.pieshare.pieception.IPieceptionService;

/**
 *
 * @author vauvenal5
 */
public class ArgumentActionExit implements IArgumentAction
{
	private IPieceptionService pieceptionService;
	
	@Override
	public void doAction()
	{
		this.pieceptionService.getCommandService().exit();
	}
	
}
