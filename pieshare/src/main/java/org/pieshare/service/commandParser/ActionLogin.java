/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.commandParser;

import java.util.Map;

/**
 *
 * @author vauve_000
 */
public class ActionLogin extends ActionBase
{
	@Override
	public void doAction(Map<String, Object> args)
	{
		String username = (String)args.get("username");
	}
	
}
