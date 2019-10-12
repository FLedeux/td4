package testMYSQL;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import factory.DAOFactory;
import factory.Persistance;
import metier.Abonnement;
import metier.Client;
import metier.Revue;

class MySQLAbonnementDAOTest {

	private DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL) ;
	private Abonnement test;
	private Client c;
	private Revue r;
	
	@BeforeEach
	public void before() {
		c= new Client(0,"Jean","Jean","53","rue de Jean","57000","JeanVille","JeanLand");
		r = new Revue(0,"jeanrevue","jean",3.5,"jean.pnj",1);
		daos.getClientDAO().create(c);
		daos.getRevueDAO().create(r);
	}
	
	@Test
	void test_create()
	{
		test = new Abonnement(c.getId(),r.getId(),"02/03/2000","02/05/2000");
		assertTrue(this.daos.getAbonnementDAO().create(test));
		daos.getAbonnementDAO().delete(test);
	}
	
	@Test
	void test_update()
	{
		test = new Abonnement(c.getId(),r.getId(),"02/03/2000","02/05/2000");
		this.daos.getAbonnementDAO().create(test);
		Abonnement test2 = new Abonnement(test.getId_client(),test.getId_revue(),"01/05/2003","05/09/2009");
		assertTrue(this.daos.getAbonnementDAO().update(test2));
		daos.getAbonnementDAO().delete(test);
	}
	
	@Test
	void test_delete()
	{
		test = new Abonnement(c.getId(),r.getId(),"02/03/2000","02/05/2000");
		this.daos.getAbonnementDAO().create(test);
		assertTrue(this.daos.getAbonnementDAO().delete(test));
	}
	
	@Test
	void test_GetByIdClientRevue()
	{
		test = new Abonnement(c.getId(),r.getId(),"02/03/2000","02/05/2000");
		this.daos.getAbonnementDAO().create(test);
		assertEquals(this.daos.getAbonnementDAO().GetByClientEtRevue(test),test);
		daos.getAbonnementDAO().delete(test);
	}
	
	@Test
	void test_GetByClient()
	{
		ArrayList<Abonnement> array= new ArrayList<Abonnement>();
		test = new Abonnement(c.getId(),r.getId(),"02/03/2000","02/05/2000");
		array.add(test);
		this.daos.getAbonnementDAO().create(test);
		assertEquals(daos.getAbonnementDAO().GetByIDClient(array.get(0)),array);
		for(int i=0;i<array.size();i++) {
			daos.getAbonnementDAO().delete(array.get(i));
		}
	}
	
	@Test
	void test_GetByRevue()
	{
		ArrayList<Abonnement> array= new ArrayList<Abonnement>();
		test = new Abonnement(c.getId(),r.getId(),"02/03/2000","02/05/2000");
		array.add(test);
		this.daos.getAbonnementDAO().create(test);
		assertEquals(daos.getAbonnementDAO().GetByIDRevue(array.get(0)),array);
		for(int i=0;i<array.size();i++) {
			daos.getAbonnementDAO().delete(array.get(i));
		}
	}
	@Test
	void test_GetBydate_debut()
	{
		ArrayList<Abonnement> array= new ArrayList<Abonnement>();
		test = new Abonnement(c.getId(),r.getId(),"01/01/2019","02/01/2019");
		array.add(test);
		this.daos.getAbonnementDAO().create(test);
		assertEquals(daos.getAbonnementDAO().GetByDateDebut(array.get(0)),array);
		for(int i=0;i<array.size();i++) {
			daos.getAbonnementDAO().delete(array.get(i));
		}
	}
	@Test
	void test_GetBydate_fin()
	{
		ArrayList<Abonnement> array= new ArrayList<Abonnement>();
		test = new Abonnement(c.getId(),r.getId(),"02/03/2000","02/05/2019");
		array.add(test);
		this.daos.getAbonnementDAO().create(test);
		assertEquals(daos.getAbonnementDAO().GetByDateFin(array.get(0)),array);
		
		for(int i=0;i<array.size();i++) {
			daos.getAbonnementDAO().delete(array.get(i));
		}
	}
	
	
	
	
	
	@Test
	void test_create_deja_existant()
	{
		test = new Abonnement(c.getId(),r.getId(),"02/03/2000","02/05/2000");
		this.daos.getAbonnementDAO().create(test);
		try {
			this.daos.getAbonnementDAO().create(test);
			fail();
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
		daos.getAbonnementDAO().delete(test);
	}
	
	
	@Test
	void test_update_Revue_manquante()
	{
		try {
			this.daos.getAbonnementDAO().update(new Abonnement(c.getId(),-1,"02/03/2000","02/05/2000"));
			fail();
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	
	@Test
	void test_delete_Revue_manquante()
	{
		try {
			this.daos.getAbonnementDAO().delete(new Abonnement(c.getId(),-1,"02/03/2000","02/05/2000"));
			fail();
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	
	@Test
	void test_GetByIdClientRevue_Revue_manquant()
	{
		test = new Abonnement(c.getId(),-1,"02/03/2000","02/05/2000");
		try {
			this.daos.getAbonnementDAO().GetByClientEtRevue(new Abonnement(test.getId_client(),-1,test.getDate_debut(),test.getDate_fin()));
			fail();
		}catch(IllegalArgumentException e) {
			assertTrue(true);

		}
	}
	
	
	
	
	
	@Test
	void test_update_Client_manquante()
	{
		try {
			this.daos.getAbonnementDAO().update(new Abonnement(-1,r.getId(),"02/03/2000","02/05/2000"));
			fail();
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	
	@Test
	void test_delete_Client_manquante()
	{
		try {
			this.daos.getAbonnementDAO().delete(new Abonnement(-1,r.getId(),"02/03/2000","02/05/2000"));
			fail();
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}
	}
	
	@Test
	void test_GetByIdClientRevue_Client_manquant()
	{
		test = new Abonnement(-1,r.getId(),"02/03/2000","02/05/2000");
		try {
			this.daos.getAbonnementDAO().GetByClientEtRevue(new Abonnement(-1,test.getId_revue(),test.getDate_debut(),test.getDate_fin()));
			fail();
		}catch(IllegalArgumentException e) {
			assertTrue(true);
		}

	}
	
	@AfterEach
	public void after() {
		daos.getClientDAO().delete(c);
		daos.getRevueDAO().delete(r);
	}

}
