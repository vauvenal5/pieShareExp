/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pietools.pieplate.service.tcp;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import org.pietools.pieplate.service.api.ISearchTcpPortService;
import org.pietools.pieutils.PieLogger;

/**
 *
 * @author vauvenal5
 */
class TCPListenerService implements Runnable
{

	private int port = -1;

	public void setTcpPortSearcher(ISearchTcpPortService tcpPortSearcher)
	{
		port = tcpPortSearcher.getNextFreePort();
	}

	public void run()
	{
		//ToDo: Switch off with shut down event
		while (true)
		{
			ServerSocket welcomeSocket;
			try
			{
				welcomeSocket = new ServerSocket(57977);
				Socket connectionSocket = welcomeSocket.accept();
			}
			catch (IOException ex)
			{
				PieLogger.error(TCPListenerService.class, "Error while starting Socket in TCPListener");
				//TODO: Think about that you asshole
			}
		}

	}
}
