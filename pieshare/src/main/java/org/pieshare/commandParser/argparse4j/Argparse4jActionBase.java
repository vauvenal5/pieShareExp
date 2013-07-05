/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.commandParser.argparse4j;

import java.util.Map;
import net.sourceforge.argparse4j.inf.Argument;
import net.sourceforge.argparse4j.inf.ArgumentAction;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.ArgumentParserException;
import org.pieshare.commandParser.IArgumentAction;

/**
 *
 * @author vauvenal5
 */
public class Argparse4jActionBase implements ArgumentAction
{
	private IArgumentAction action;
	
	public Argparse4jActionBase(IArgumentAction action)
	{
		this.action = action;
	}
	
	@Override
	public void run(ArgumentParser ap, Argument argmnt, Map<String, Object> map, String string, Object o) throws ArgumentParserException
	{
		this.action.doAction();
	}	
	
	@Override
	public void onAttach(Argument argmnt)
	{
	}

	@Override
	public boolean consumeArgument()
	{
		return true;
	}
	
}
