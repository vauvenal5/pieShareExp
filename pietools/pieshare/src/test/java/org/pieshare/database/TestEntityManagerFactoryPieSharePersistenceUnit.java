/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package org.pieshare.database;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;

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

	private TestUserEntity testUser1;
	private TestUserEntity testUser2;

	@Before
	public void initEmfAndEm()
	{
		testUser1 = new TestUserEntity();
		testUser1.setName("User1");
		testUser2 = new TestUserEntity();
		testUser2.setName("testUser2");

		emf = Persistence.createEntityManagerFactory("pieSharePersistenceUnit");
		em = emf.createEntityManager();
	}

	@After
	public void cleanup()
	{
		em.close();
	}

	@SuppressWarnings("unchecked")
    @Test
    public void insertAndRetrieve()
	{
		em.getTransaction().begin();
		em.persist(testUser1);
		em.persist(testUser2);
		em.getTransaction().commit();

		final List<TestUserEntity> list = em.createQuery("select p from TestUserEntity p")
				.getResultList();

		assertEquals(2, list.size());
		for (TestUserEntity current : list)
		{
			final String firstName = current.getName();
			System.out.println(firstName + ": GeneratedID: " + current.getId());
			assertTrue(firstName.equals("User1") || firstName.equals("testUser2"));
		}
	}
}
