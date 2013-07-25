/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.commandParser;

/**
 *
 * @author vauvenal5
 */
public interface ICommandParserService
{

	public void parseArgs(String[] args) throws Exception;

	public void setActionExit(IAction action);
	
	public void setActionLogin(IAction action);
}
