package dao;

import java.util.ArrayList;

import metier.Abonnement;

public interface AbonnementDAO extends DAO<Abonnement>{
	
	public abstract ArrayList<Abonnement> GetByIDClient(Abonnement abonnement);
	public abstract ArrayList<Abonnement> GetByIDRevue(Abonnement abonnement);
	public abstract Abonnement GetByClientEtRevue(Abonnement abonnement);
	public abstract ArrayList<Abonnement> GetByDateDebut(Abonnement abonnement);
	public abstract ArrayList<Abonnement> GetByDateFin(Abonnement abonnement);
	 

}
