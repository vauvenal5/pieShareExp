/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.pieception;

import javax.annotation.PostConstruct;
import org.pieshare.service.core.IPieService;

/**
 *
 * @author vauve_000
 */
public class PieceptionService implements IPieceptionService
{

	private ICmdServerService serverService;
	private ICmdClientService clientService;
	private IPieService pieService;
	private boolean startupAllowed;

	public PieceptionService()
	{
	}

	@PostConstruct
	public void postPieceptionController()
	{
            //if there is an running pieShare instance don't start a new one!
            if(this.pieService.isPieShareRunning())
            {
                this.serverService = null;
                return;
            }
            
            //else start instance as server
            this.clientService = null;
            this.pieService.executeService(this.serverService);
	}

	@Override
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

	public void setCmdServerService(ICmdServerService service)
	{
		this.serverService = service;
	}

	public void setCmdClientService(ICmdClientService service)
	{
		this.clientService = service;
	}
}
