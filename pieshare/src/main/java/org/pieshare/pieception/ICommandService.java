/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.pieception;

import java.rmi.Remote;
import java.rmi.RemoteException;
import org.pieshare.common.IRunnable;

/**
 *
 * @author vauvenal5
 */
public interface ICommandService extends Remote, IRunnable
{
    void exit();
}
