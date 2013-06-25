/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieception;

/**
 *
 * @author vauve_000
 */
public class PieceptionController 
{
	private ICmdServerService serverService;
	private ICmdClientService clientService;
	//TODOSv: include MySelfDao!!!
	private boolean startupAllowed;
	private ICommandService commandService;
	
	public PieceptionController()
	{}
	
	public boolean isStartupAllowed()
	{
		return this.startupAllowed;
	}
	
	public ICommandService getCommandService()
	{
		return this.commandService;
	}
	
	/*public void setMySelfDao(dao)
	{
		this.startupAllowed = dao.getPid ? null
		this.commandService = (ICommandService) serverService ? ClientSrevice;
		serverService ? ClientSrevice = null;
	}*/
	
	public void setCmdServerService(ICmdServerService service)
	{
		this.serverService = service;
	}
	
	public void setCmdClientService(ICmdClientService service)
	{
		this.clientService = service;
	}
}
