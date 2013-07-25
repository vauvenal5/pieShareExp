/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.pieception;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author vauvenal5
 */
public interface ICommandService
{

	void login(String username, String password);

	void exit();
}
