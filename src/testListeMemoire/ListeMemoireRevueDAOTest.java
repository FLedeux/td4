package testListeMemoire;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import factory.DAOFactory;
import factory.Persistance;
import metier.Revue;

class ListeMemoireRevueDAOTest {
	
	
	private DAOFactory daos = DAOFactory.getDAOFactory(Persistance.ListeMemoire) ;
	private Revue test;

	
	
	@Test
	void test_create()
	{
		test = new Revue(0,"test","ceci est un test",3,"test.jpg",0);
		assertTrue(this.daos.getRevueDAO().create(test));
	}
	
	@Test
	void testGetById()
	{
		test = new Revue(0,"test","ceci est un test",3,"test.jpg",0);
		this.daos.getRevueDAO().create(test);
		assertEquals(this.daos.getRevueDAO().getById(test.getId()),test);
	}
	
	@Test
	void testGetByTitre()
	{
		test = new Revue(0,"banane","ceci est un test",3,"test.jpg",0);
		this.daos.getRevueDAO().create(test);
		assertEquals(this.daos.getRevueDAO().getByTitre(test),test);
	}
	
	@Test
	void test_update()
	{
		test = new Revue(0,"test","ceci est un test",3,"test.jpg",0);
		this.daos.getRevueDAO().create(test);
		Revue test2 = new Revue(test.getId(),"tt","rr",3,"tt.jpg",0);
		assertTrue(this.daos.getRevueDAO().update(test2));
	}
	
	@Test
	void test_delete()
	{
		test = new Revue(0,"test","ceci est un test",3,"test.jpg",0);
		this.daos.getRevueDAO().create(test);
		assertTrue(this.daos.getRevueDAO().delete(test));
	}
	
	
	
	@Test
	void testperiodicite()
	{
		ArrayList<Revue> array = new ArrayList<Revue>();
		test = new Revue(0,"test1","ceci est un test",3,"test.jpg",1);
		this.daos.getRevueDAO().create(test);
		array.add(test);
		test = new Revue(0,"test2","ceci est un test",3,"test.jpg",1);
		this.daos.getRevueDAO().create(test);
		array.add(test);
		assertEquals(this.daos.getRevueDAO().GetByPerio(array.get(0)),array);
	}
	

	
	
	
	
	@Test
	void test_update_impossible()
	{
		try {
		this.daos.getRevueDAO().update(new Revue(-1,"test","ceci est un test",3,"test.jpg",0));
		fail();
		}
		catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	@Test
	void test_delete_impossible()
	{
		try {
			this.daos.getRevueDAO().delete(new Revue(-1,"test","ceci est un test",3,"test.jpg",0));
			fail();
			}
			catch(IllegalArgumentException e) {
				assertTrue(true);
			}
	}
	@Test
	void testGetById_impossible()
	{
		test = new Revue(-1,"test","ceci est un test",3,"test.jpg",0);
		try {
		this.daos.getRevueDAO().getById(test.getId());
		fail();
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void testGetByTitre_impossible()
	{
		test = new Revue(0,"colibri","ceci est un test",3,"test.jpg",0);
		try {
		this.daos.getRevueDAO().getByTitre(test);
		fail();
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	

}
