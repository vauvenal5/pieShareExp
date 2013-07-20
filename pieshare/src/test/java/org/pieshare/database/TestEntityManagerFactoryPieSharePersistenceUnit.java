/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.database;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

/**
 *
 * @author richy
 */
public class TestEntityManagerFactoryPieSharePersistenceUnit
{

	private EntityManagerFactory emf;
	private EntityManager em;

	@Before
	public void initEmfAndEm()
	{
		emf = Persistence.createEntityManagerFactory("pieSharePersistenceUnit");
		em = emf.createEntityManager();
	}

	@After
	public void cleanup()
	{
		em.close();
	}

	@Test
	public void emptyTest()
	{
	}
}
