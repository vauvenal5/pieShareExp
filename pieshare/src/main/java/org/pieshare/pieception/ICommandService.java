/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieception;

import java.rmi.Remote;
import java.rmi.RemoteException;

/**
 *
 * @author vauvenal5
 */
public interface ICommandService extends Remote, Runnable
{

	void login(String username, String password);

	void exit();
}
