package liste_memoire;

import java.util.ArrayList;

import dao.ClientDAO;
import metier.Client;


public class ListeMemoireClientDAO implements ClientDAO{

	private static ListeMemoireClientDAO instance;

	private ArrayList<Client> donnees;
	
	
	public static ListeMemoireClientDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireClientDAO();
		}

		return instance;
	}
	
	private ListeMemoireClientDAO() {
		this.donnees = new ArrayList<Client>();
	}
	



	@Override
	public Client getById(int id) {
		int idx = this.donnees.indexOf(new Client(id, "","","","","","",""));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public boolean create(Client object) {
		object.setId(1);
		
		while (this.donnees.contains(object)) {

			object.setId(object.getId() + 1);
		}
		boolean ok = this.donnees.add(object);
		
		return ok;
	}

	@Override
	public boolean update(Client object) {
		int idx = this.donnees.indexOf(object);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, object);
		}
		
		return true;
	}

	@Override
	public boolean delete(Client object) {
		Client supprime;
		
		int idx = this.donnees.indexOf(object);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		
		return object.equals(supprime);
	}


	@Override
	public ArrayList<Client> GetByNomPrenom(Client client) {
		int i=0;
		ArrayList<Client> array = new ArrayList<Client>();
		while(i<this.donnees.size()) {
			if ((this.donnees.get(i).getNom()==client.getNom())&&(this.donnees.get(i).getPrenom()==client.getPrenom())) {
				array.add(this.donnees.get(i));
			}
			i++;
		}
		return array;
	}

	@Override
	public ArrayList<Client> GetByAdresse(Client client) {
		int i=0;
		ArrayList<Client> array = new ArrayList<Client>();
		while(i<this.donnees.size()) {
			if ((this.donnees.get(i).getNo_rue()==client.getNo_rue())&&(this.donnees.get(i).getVoie()==client.getVoie())) {
				array.add(this.donnees.get(i));
			}
			i++;
		}
		return array;
	}

	@Override
	public ArrayList<Client> GetByCode_Postal(Client client) {
		int i=0;
		ArrayList<Client> array = new ArrayList<Client>();
		while(i<this.donnees.size()) {
			if (this.donnees.get(i).getCode_postal()==client.getCode_postal()) {
				array.add(this.donnees.get(i));
			}
			i++;
		}
		return array;
	}

	@Override
	public ArrayList<Client> GetByVille(Client client) {
		int i=0;
		ArrayList<Client> array = new ArrayList<Client>();
		while(i<this.donnees.size()) {
			if (this.donnees.get(i).getVille()==client.getVille()) {
				array.add(this.donnees.get(i));
			}
			i++;
		}
		return array;
	}

	@Override
	public ArrayList<Client> GetByPays(Client client) {
		int i=0;
		ArrayList<Client> array = new ArrayList<Client>();
		while(i<this.donnees.size()) {
			if (this.donnees.get(i).getPays()==client.getPays()) {
				array.add(this.donnees.get(i));
			}
			i++;
		}
		return array;
	}

}
