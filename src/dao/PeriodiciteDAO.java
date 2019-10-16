package dao;

import java.util.ArrayList;

import javafx.util.Callback;
import metier.Periodicite;

public interface PeriodiciteDAO extends DAOGetByID<Periodicite>{
	
	public abstract Periodicite getByNom(Periodicite periodicite);

	public abstract ArrayList<Periodicite> findAll();

}
