package dao;

import java.util.ArrayList;

import metier.Client;

public interface ClientDAO extends DAOGetByID<Client>{

	public abstract ArrayList<Client> GetByNomPrenom(Client client);
	public abstract ArrayList<Client> GetByAdresse(Client client);
	public abstract ArrayList<Client> GetByCode_Postal(Client client);
	public abstract ArrayList<Client> GetByVille(Client client);
	public abstract ArrayList<Client> GetByPays(Client client);
	
}
