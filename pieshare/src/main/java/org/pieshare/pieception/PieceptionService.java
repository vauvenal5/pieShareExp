/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieception;

import javax.annotation.PostConstruct;
import org.pieshare.pieshare.IPieService;

/**
 *
 * @author vauve_000
 */
public class PieceptionService implements IPieceptionService
{

	private ICommandService serverService;
	private ICommandService clientService;
	private IPieService pieService;
	private boolean startupAllowed;

	public PieceptionService()
	{
	}

	@PostConstruct
	public void postPieceptionController()
	{
		this.pieService.executeService(this.getCommandService());
	}

	public ICommandService getCommandService()
	{
		if (this.pieService.isPieShareRunning())
		{
			return this.clientService;
		}

		return this.serverService;
	}

	public void setPieService(IPieService service)
	{
		this.pieService = service;
	}

	public void setCmdServerService(ICommandService service)
	{
		this.serverService = service;
	}

	public void setCmdClientService(ICommandService service)
	{
		this.clientService = service;
	}
}
