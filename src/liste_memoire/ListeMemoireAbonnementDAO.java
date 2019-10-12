package liste_memoire;

import java.util.ArrayList;

import dao.AbonnementDAO;
import metier.Abonnement;

public class ListeMemoireAbonnementDAO implements AbonnementDAO{

	
	private static ListeMemoireAbonnementDAO instance;

	private ArrayList<Abonnement> donnees;
	
	
	public static ListeMemoireAbonnementDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireAbonnementDAO();
		}

		return instance;
	}
	
	private ListeMemoireAbonnementDAO() {
		this.donnees = new ArrayList<Abonnement>();
	}
	
	
	
	@Override
	public boolean create(Abonnement object) {

       if(this.donnees.contains(object)) {
    	   throw new IllegalArgumentException("un client ne peut pas etre abonné deux fois à la même revue");
       }
		return this.donnees.add(object);
		
	}

	@Override
	public boolean update(Abonnement object) {
		
		int idx = this.donnees.indexOf(object);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, object);
		}
		
		return true;
	}

	@Override
	public boolean delete(Abonnement object) {
		Abonnement supprime;
		
		int idx = this.donnees.indexOf(object);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return object.equals(supprime);
	}

	@Override
	public ArrayList<Abonnement> GetByIDClient(Abonnement abonnement) {
		int i=0;
		ArrayList<Abonnement> array = new ArrayList<Abonnement>();
		while(i<this.donnees.size()) {
			if (this.donnees.get(i).getId_client()==abonnement.getId_client()) {
				array.add(this.donnees.get(i));
			}
			i++;
		}
		return array;
	}

	@Override
	public ArrayList<Abonnement> GetByIDRevue(Abonnement abonnement) {
		int i=0;
		ArrayList<Abonnement> array = new ArrayList<Abonnement>();
		while(i<this.donnees.size()) {
			if (this.donnees.get(i).getId_revue()==abonnement.getId_revue()) {
				array.add(this.donnees.get(i));
			}
			i++;
		}
		return array;
	}

	@Override
	public Abonnement GetByClientEtRevue(Abonnement abonnement) {
		int idx = this.donnees.indexOf(abonnement);
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possÃ¨de cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public ArrayList<Abonnement> GetByDateDebut(Abonnement abonnement) {
		int i=0;
		ArrayList<Abonnement> array = new ArrayList<Abonnement>();
		while(i<this.donnees.size()) {
			if (this.donnees.get(i).getDate_debut()==abonnement.getDate_debut()) {
				array.add(this.donnees.get(i));
			}
			i++;
		}
		return array;
	}

	@Override
	public ArrayList<Abonnement> GetByDateFin(Abonnement abonnement) {
		int i=0;
		ArrayList<Abonnement> array = new ArrayList<Abonnement>();
		while(i<this.donnees.size()) {
			if (this.donnees.get(i).getDate_fin()==abonnement.getDate_fin()) {
				array.add(this.donnees.get(i));
			}
			i++;
		}
		return array;
	}
	
	}


