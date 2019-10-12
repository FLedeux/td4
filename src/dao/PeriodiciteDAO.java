package dao;

import metier.Periodicite;

public interface PeriodiciteDAO extends DAOGetByID<Periodicite>{
	
	public abstract Periodicite getByNom(Periodicite periodicite);

}
