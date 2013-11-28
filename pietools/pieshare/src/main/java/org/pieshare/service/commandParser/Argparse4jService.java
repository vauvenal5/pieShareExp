/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.service.commandParser;

import javax.annotation.PostConstruct;
import net.sourceforge.argparse4j.ArgumentParsers;
import net.sourceforge.argparse4j.inf.ArgumentAction;
import net.sourceforge.argparse4j.inf.ArgumentParser;
import net.sourceforge.argparse4j.inf.MutuallyExclusiveGroup;
import net.sourceforge.argparse4j.inf.Namespace;
import net.sourceforge.argparse4j.inf.Subparser;
import net.sourceforge.argparse4j.inf.Subparsers;
import org.pieshare.service.commandParser.ActionExit;
import org.pieshare.service.commandParser.ActionLogin;
import org.pieshare.service.commandParser.IAction;
import org.pieshare.service.commandParser.ICommandParserService;
import org.pieshare.service.pieception.IPieceptionService;

/**
 *
 * @author vauvenal5
 */
public class Argparse4jService implements ICommandParserService
{

	private ArgumentParser parser;	
	
	private IAction actionExit;
	private IAction actionLogin;

	public Argparse4jService()
	{
		this.parser = ArgumentParsers.newArgumentParser("pieshare");
	}

	@PostConstruct
	public void postArgparse4jService()
	{	
		//TODO: change fixed names like "username" and "exit" to be looked up in the database!
		Subparsers parsers = this.parser.addSubparsers();
		
		Subparser parser = parsers.addParser("exit").setDefault("func", this.actionExit);
		
		parser = parsers.addParser("login").setDefault("func", this.actionLogin);
		parser.addArgument("username").type(String.class);
	}

	@Override
	public void parseArgs(String[] args) throws Exception
	{
		Namespace n = parser.parseArgs(args);
		((IAction)n.get("func")).doAction(n.getAttrs());
	}

	@Override
	public void setActionExit(IAction action)
	{
		this.actionExit = action;
	}

	@Override
	public void setActionLogin(IAction action)
	{
		this.actionLogin = action;
	}
}
