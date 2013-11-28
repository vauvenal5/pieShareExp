/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.commandParser;

import org.pieshare.service.pieception.IPieceptionService;

/**
 *
 * @author vauve_000
 */
public abstract class ActionBase implements IAction
{
	protected IPieceptionService pieceptionService;
	
	public void setPieceptionService(IPieceptionService service)
	{
		this.pieceptionService = service;
	}
}
