package testMYSQL;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;


import org.junit.jupiter.api.Test;

import factory.DAOFactory;
import factory.Persistance;
import metier.Client;

class MySQLClientDAOTest {

	private DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
	private Client test;
	
	
	@Test
	void test_create()
	{
		test = new Client(0,"Jean","Test","53","rue du test","57070","Testville","Testland");
		assertTrue(this.daos.getClientDAO().create(test));
		daos.getClientDAO().delete(test);
	}
	
	@Test
	void testGetById()
	{
		test = new Client(0,"Jean","Test","53","rue du test","57070","Testville","Testland");
		this.daos.getClientDAO().create(test);
		assertEquals(this.daos.getClientDAO().getById(test.getId()),test);
		daos.getClientDAO().delete(test);
	}

	@Test
	void test_update()
	{
		test = new Client(0,"Jean","Test","53","rue du test","57070","Testville","Testland");
		this.daos.getClientDAO().create(test);
		Client test2 = new Client(test.getId(),"Jack","Test","53","rue du test","57070","Testville","Testland");
		assertTrue(this.daos.getClientDAO().update(test2));
		daos.getClientDAO().delete(test);
	}
	
	@Test
	void test_delete()
	{
		test = new Client(0,"Jean","Test","53","rue du test","57070","Testville","Testland");
		this.daos.getClientDAO().create(test);
		assertTrue(this.daos.getClientDAO().delete(test));
	}
	
	
	
	@Test
	void test_GetByNomPrenom()
	{
		ArrayList<Client> array= new ArrayList<Client>();
		test = new Client(0,"Jack","Pierre","53","rue du test","57070","Testville","Testland");
		array.add(test);
		this.daos.getClientDAO().create(test);
		assertEquals(daos.getClientDAO().GetByNomPrenom(test),array);
		
		for(int i=0;i<array.size();i++) {
			daos.getClientDAO().delete(array.get(i));
		}
	}
	@Test
	void test_GetByAdresse()
	{
		ArrayList<Client> array= new ArrayList<Client>();
		test = new Client(0,"Jack","Paul","54","rue du pont","57070","Testville","Testland");
		array.add(test);
		this.daos.getClientDAO().create(test);
		assertEquals(daos.getClientDAO().GetByAdresse(test),array);
		
		for(int i=0;i<array.size();i++) {
			daos.getClientDAO().delete(array.get(i));
		}
	}
	@Test
	void test_GetByCodePostal()
	{
		ArrayList<Client> array= new ArrayList<Client>();
		test = new Client(0,"Jack","Paul","53","rue du test","57050","Testville","Testland");
		array.add(test);
		this.daos.getClientDAO().create(test);
		assertEquals(daos.getClientDAO().GetByCode_Postal(test),array);
		
		for(int i=0;i<array.size();i++) {
			daos.getClientDAO().delete(array.get(i));
		}
	}
	@Test
	void test_GetByVille()
	{
		ArrayList<Client> array= new ArrayList<Client>();
		test = new Client(0,"Jack","Paul","53","rue du test","57070","TestCity","Testland");
		array.add(test);
		this.daos.getClientDAO().create(test);
		assertEquals(daos.getClientDAO().GetByVille(test),array);
		
		for(int i=0;i<array.size();i++) {
			daos.getClientDAO().delete(array.get(i));
		}
	}
	@Test
	void test_GetByPays()
	{
		ArrayList<Client> array= new ArrayList<Client>();
		test = new Client(0,"Jack","Paul","53","rue du test","57070","Testville","Testia");
		array.add(test);
		this.daos.getClientDAO().create(test);
		assertEquals(daos.getClientDAO().GetByPays(array.get(0)),array);
		
		for(int i=0;i<array.size();i++) {
			daos.getClientDAO().delete(array.get(i));
		}
	}
	
	
	
	
	
	
	
	
	@Test
	void test_update_impossible()
	{
		try {
		this.daos.getClientDAO().update(test = new Client(-1,"Jean","Test","53","rue du test","57070","Testville","Testland"));
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
			this.daos.getClientDAO().delete(test = new Client(-1,"Jean","Test","53","rue du test","57070","Testville","Testland"));
			fail();
			}
			catch(IllegalArgumentException e) {
				assertTrue(true);
			}
	}
	@Test
	void testGetById_impossible()
	{
		test = new Client(-1,"Jean","Test","53","rue du test","57070","Testville","Testland");
		try {
		this.daos.getClientDAO().getById(test.getId());
		fail();
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	

	

}
