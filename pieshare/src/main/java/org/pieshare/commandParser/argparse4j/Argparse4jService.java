/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.commandParser.argparse4j;

import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import org.pieshare.commandParser.ArgumentActionExit;
import org.pieshare.commandParser.ICommandParserService;
import org.pieshare.pieception.IPieceptionService;

/**
 *
 * @author vauvenal5
 */
public class Argparse4jService implements ICommandParserService
{
	private ArgumentParser parser;
	
	private ArgumentActionExit actionExit;
	
	public Argparse4jService()
	{
		this.parser = ArgumentParsers.newArgumentParser("pieshare");
		this.parser.addArgument("exit").action(new Argparse4jActionBase(actionExit));
	}

	@Override
	public void parseArgs(String[] args) throws Exception
	{
		parser.parseArgs(args);
	}

	@Override
	public void setArgumentActionExit(ArgumentActionExit action)
	{
		this.actionExit = action;
	}
}
