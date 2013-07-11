/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieception;

import java.rmi.AccessException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import javax.annotation.PostConstruct;
import org.pieshare.event.eventBase.EventCallback;
import org.pieshare.event.events.ShutdownEvent;
import org.pieshare.pieshare.IPieService;

/**
 *
 * @author vauvenal5
 */
public class CmdClientService implements ICmdClientService
{

	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CmdClientService.class);
	private Registry registry;
	private ICommandService serverService;
	private IPieService pieService;
	
	@PostConstruct
	public void postCmdClientService()
	{
		getService();
	}

	/*I beliebe this is not needed because it is enough if when the server unbinds the registry.
	 * @EventCallback(eventClass = ShutdownEvent.class)
	public void shutdown()
	{
		try
		{
			this.registry.unbind(this.pieService.getPieceptionBindingName());
		}
		catch (RemoteException ex)
		{
			logger.debug("Pieception failed! Err: " + ex.getMessage());
		}
		catch (NotBoundException ex)
		{
			logger.debug("Pieception failed! Err: " + ex.getMessage());
		}
	}*/

	@Override
	public void exit()
	{
		this.serverService.exit();
	}

	private void getService()
	{
		try
		{
			this.registry = LocateRegistry.getRegistry(this.pieService.getPieceptionRegistryHost(), this.pieService.getPieceptionRegistryPort());
			
		}
		catch (RemoteException ex)
		{
			logger.debug("Pieception failed! Err: " + ex.getMessage());
		}
		
		try
		{
			this.serverService = (ICommandService) this.registry.lookup(this.pieService.getPieceptionBindingName());
                        //if server service can be retrieved we will stay in command client mode
                        this.pieService.setPieShareIsRunning();
                }
		catch (RemoteException ex)
		{
			ex.printStackTrace();
		}
		catch (NotBoundException ex)
		{
			ex.printStackTrace();
		}
	}

	@Override
	public void login(String username, String password)
	{
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	public void setPieService(IPieService service)
	{
		this.pieService = service;
	}
}
