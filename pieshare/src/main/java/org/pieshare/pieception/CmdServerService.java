/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieception;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.EventListener;
import org.pieshare.common.eventBase.IEventBaseService;
import org.pieshare.common.eventBase.EventCallback;
import org.pieshare.common.events.ShutdownEvent;
import org.pieshare.pieshare.IPieService;

/**
 *
 * @author vauvenal5
 */
public class CmdServerService implements ICommandService
{
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(CmdServerService.class);
	private Registry registry;
	private IPieService pieService;
	
    @Override
	@EventCallback(eventClass=ShutdownEvent.class)
    public void exit() 
    {
		//todo sv: implementen shutdown event chain like in dslab
        throw new UnsupportedOperationException("SVETI IS GREAT!"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() 
    {
        //registerService();;
    }
	
	private void registerService()
	{
		try 
		{
			this.registry = LocateRegistry.createRegistry(this.pieService.getPieceptionRegistryPort());
			this.registry.rebind(this.pieService.getPieceptionBindingName(), this);
		} 
		catch (RemoteException ex) 
		{
			logger.debug("Pieception failed! Err: " + ex.getMessage());
		} 
	}
	
	public void setPieService(IPieService service)
	{
		this.pieService = service;
	}
}
