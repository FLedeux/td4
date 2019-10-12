package dao;

import java.util.ArrayList;

import metier.Revue;

public interface RevueDAO extends DAOGetByID<Revue>{
	
	public abstract Revue getByTitre(Revue revue);
	public abstract ArrayList<Revue> GetByPerio(Revue revue);
	

}
