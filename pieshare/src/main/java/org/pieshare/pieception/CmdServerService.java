/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieception;

import java.rmi.AccessException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.pieshare.filewatcher.FileWatcher;
import org.pieshare.pieception.ICommandService;
import org.pieshare.pieshare.IPieService;

/**
 *
 * @author vauvenal5
 */
public class CmdServerService implements ICommandService
{
	private static final org.apache.log4j.Logger logger = org.apache.log4j.Logger.getLogger(FileWatcher.class);
	private Registry registry;
	private IPieService pieService;
	
    @Override
    public void exit() 
    {
		//execute stuff
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void run() 
    {
		
        //ToDoSv: register service
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
	
	private void registerService()
	{
		try 
		{
			this.registry = LocateRegistry.createRegistry(this.pieService.getPieceptionPort());
			this.registry.rebind(this.pieService.getPieceptionBindingName(), this);
		} 
		catch (RemoteException ex) 
		{
			logger.debug("Pieception failed! Err: " + ex.getMessage());
		} 
	}
}
