/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.user;

/**
 *
 * @author richy
 */
public class User
{
	private String username;
	private String password;
	
	public User(String username, String password)
	{
		this.password = password;
		this.username = username;
	}

	public String getPasswort()
	{
		return password;
	}

	public String getUsername()
	{
		return username;
	}
}
