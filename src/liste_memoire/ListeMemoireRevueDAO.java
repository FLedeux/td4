package liste_memoire;

import java.util.ArrayList;

import dao.RevueDAO;
import metier.Revue;

public class ListeMemoireRevueDAO implements RevueDAO{

	private static ListeMemoireRevueDAO instance;

	private ArrayList<Revue> donnees;
	
	
	
	public static ListeMemoireRevueDAO getInstance() {

		if (instance == null) {
			instance = new ListeMemoireRevueDAO();
		}

		return instance;
	}
	
	private ListeMemoireRevueDAO() {

		this.donnees = new ArrayList<Revue>();
	}
	

	@Override
	public Revue getById(int id) {
		
		int idx = this.donnees.indexOf(new Revue(id, "","",0,"",0));
		if (idx == -1) {
			throw new IllegalArgumentException("Aucun objet ne possède cet identifiant");
		} else {
			return this.donnees.get(idx);
		}
	}

	@Override
	public boolean create(Revue object) {
		object.setId(1);
		
		while (this.donnees.contains(object)) {

			object.setId(object.getId() + 1);
		}
		boolean ok = this.donnees.add(object);
		
		return ok;
	}

	@Override
	public boolean update(Revue object) {
		int idx = this.donnees.indexOf(object);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de modification d'un objet inexistant");
		} else {
			
			this.donnees.set(idx, object);
		}
		return true;
		
	}

	@Override
	public boolean delete(Revue object) {
		Revue supprime;
		
		int idx = this.donnees.indexOf(object);
		if (idx == -1) {
			throw new IllegalArgumentException("Tentative de suppression d'un objet inexistant");
		} else {
			supprime = this.donnees.remove(idx);
		}
		return object.equals(supprime);
		
	}

	@Override
	public Revue getByTitre(Revue revue) {
		
		int i=0;
		while((i<this.donnees.size())&&(this.donnees.get(i).getTitre()!=revue.getTitre())) {
			i++;
		}
		if(i>=this.donnees.size()) {
			throw new IllegalArgumentException("Aucun objet ne possède ce nom");
		}
		return this.donnees.get(i);
		
	}

	
	@Override
	public ArrayList<Revue> GetByPerio(Revue revue) {
		int i=0;
		ArrayList<Revue> array = new ArrayList<Revue>();
		while(i<this.donnees.size()) {
			if (this.donnees.get(i).getId_perio()==revue.getId_perio()) {
				array.add(this.donnees.get(i));
			}
			i++;
		}
		return array;
		
	}

}
