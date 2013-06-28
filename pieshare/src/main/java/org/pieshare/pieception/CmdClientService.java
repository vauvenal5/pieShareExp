/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieception;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import org.pieshare.pieshare.IPieService;

/**
 *
 * @author vauvenal5
 */
public class CmdClientService implements ICommandService
{
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CmdClientService.class);
	private Registry registry;
	private ICommandService serverService;
	private IPieService pieService;
	
    @Override
    public void run() 
    {
        getService();
    }

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
			this.serverService = (ICommandService) this.registry.lookup(this.pieService.getPieceptionBindingName());
		} 
		catch (NotBoundException ex) 
		{
			logger.debug("Pieception failed! Err: " + ex.getMessage());
		} 
		catch (RemoteException ex) 
		{
			logger.debug("Pieception failed! Err: " + ex.getMessage());
		}
	    
	}
	
}
