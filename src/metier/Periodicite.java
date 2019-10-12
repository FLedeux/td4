package metier;

import java.util.Scanner;

import factory.DAOFactory;

public class Periodicite {

	private int id;
	private String nom;
	
	public Periodicite(int id, String nom) {
		this.setId(id);
		this.setNom(nom);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Periodicite [id=" + id + ", nom=" + nom + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Periodicite other = (Periodicite) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	public static void saisir_action(DAOFactory factory) {
		Scanner sc = new Scanner(System.in);
		int Input=0;
		System.out.println("choix de l'opération :1 pour créer, 2 pour modifier, 3 pour supprimer, 4 pour trouver par id, 5 pour trouver par nom, 6 pour revenir en arrière");
		do {
		Input = sc.nextInt();
			
		switch(Input) {
		case 1 : 
			boolean i = factory.getPeriodiciteDAO().create(Periodicite.saisir_tout());
			if (i!= true) {
				System.out.println("l'opération a rencontré un problème");
			}
			break;
		case 2 :
			i = factory.getPeriodiciteDAO().update(Periodicite.saisir_tout());
			if (i!= true) {
				System.out.println("l'opération a rencontré un problème");
			}
			break;
		
		case 3 :
			i = factory.getPeriodiciteDAO().delete(Periodicite.saisir_id());
			if (i!= true) {
				System.out.println("l'opération a rencontré un problème");
			}
			break;
		
		case 4 :
			System.out.println(factory.getPeriodiciteDAO().getById(Periodicite.saisir_id().getId()));
			break;
		
		case 5 :
			System.out.println(factory.getPeriodiciteDAO().getByNom(Periodicite.saisir_nom()));
			break;

		}
		}while((Input>6)||(Input<0));
	}
	
	public static Periodicite saisir_tout() {
		Periodicite p1 = Periodicite.saisir_id();
		p1.setNom(Periodicite.saisir_nom().getNom());
		return p1;
		
	}
	
	public static Periodicite saisir_id() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir l'id d ela périodicté");
		int id = sc.nextInt();
		
		return new Periodicite(id,"");
	}
	
	public static Periodicite saisir_nom() {
		Scanner sc = new Scanner(System.in);
		System.out.println("Saisir le nom de la périodicité");
		String nom = sc.nextLine();
		
		return new Periodicite(0,nom); 
	}
	
	
}
