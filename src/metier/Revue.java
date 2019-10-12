package metier;

import java.util.Scanner;

import factory.DAOFactory;

public class Revue {
	private int id;
	private String titre;
	private String description;
	private double tarif_numero;
	private String visuel;
	private int  id_perio;
	
	public Revue(int id, String titre,String description,double tarif_numero,String visuel,int id_perio) {
		this.setId(id);
		this.setTitre(titre);
		this.setDescription(description);
		this.setTarif_numero(tarif_numero);
		this.setVisuel(visuel);
		this.setId_perio(id_perio);

	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getTarif_numero() {
		return tarif_numero;
	}

	public void setTarif_numero(double tarif_numero) {
		this.tarif_numero = tarif_numero;
	}

	public String getVisuel() {
		return visuel;
	}

	public void setVisuel(String visuel) {
		this.visuel = visuel;
	}

	public int getId_perio() {
		return id_perio;
	}

	public void setId_perio(int id_perio) {
		this.id_perio = id_perio;
	}

	@Override
	public String toString() {
		return "Revue [id=" + id + ", titre=" + titre + ", description=" + description + ", tarif_numero="
				+ tarif_numero + ", visuel=" + visuel + ", id_perio=" + id_perio + "]";
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Revue other = (Revue) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}


	
	public static void saisir_action(DAOFactory factory) {
		Scanner sc = new Scanner(System.in);
		int Input=0;
		System.out.println("choix de l'opération :1 pour créer, 2 pour modifier, 3 pour supprimer, 4 pour trouver par id, 5 pour trouver par titre, 6 pour trouver par périodicité, 7 pour revenir en arrière");
		do {
		Input = sc.nextInt();
			
		switch(Input) {
		case 1 : 
			boolean i = factory.getRevueDAO().create(Revue.saisir_creation());
			if (i!= true) {
				System.out.println("l'opération a rencontré un problème");
			}
			break;
		case 2 :
			i = factory.getRevueDAO().update(Revue.saisir_modification());
			if (i!= true) {
				System.out.println("l'opération a rencontré un problème");
			}
			break;
		
		case 3 :
			i = factory.getRevueDAO().delete(Revue.saisir_id());
			if (i!= true) {
				System.out.println("l'opération a rencontré un problème");
			}
			break;
		
		case 4 :
			System.out.println(factory.getRevueDAO().getById(Revue.saisir_id().getId()));
			break;
		
		case 5 :
			System.out.println(factory.getRevueDAO().getByTitre(Revue.saisir_titre()));
			break;
		
		case 6 :
			System.out.println(factory.getRevueDAO().GetByPerio(Revue.saisir_periodicite()));
			break;
		
		case 7 :
			System.out.println("retour au menu précédent");
		
		}
		}while((Input>8)||(Input<0));
	}
	
	public static Revue saisir_creation() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("veuillez saisir le titre");
		String titre = sc.nextLine();
		
		System.out.println("veuillez saisir la description");
		String description = sc.nextLine();
		
		System.out.println("veuillez saisir le prix");
		double prix = sc.nextDouble();
		
		System.out.println("veuillez saisir le nom de l'image");
		String image = sc.nextLine();
		
		System.out.println("veuillez saisir l'id de la périodicité");
		int idp = sc.nextInt();
		
		return new Revue(0,titre,description,prix,image,idp);
		
	}
	
	public static Revue saisir_modification() {
		Revue r1 = Revue.saisir_id();
		Revue r2 = Revue.saisir_creation();
		r2.setId(r1.getId());
		return r2;
		
	}
	
	public static Revue saisir_id() {
		Scanner sc = new Scanner(System.in);	
		System.out.println("veuillez saisir l'id de l'élément");
		int id = sc.nextInt();	
		return new Revue(id,"","",0,"",0);
		
	}
	
	public static Revue saisir_titre() {
		Scanner sc = new Scanner(System.in);		
		System.out.println("veuillez saisir le titre de l'élément");
		String titre = sc.nextLine();
		
		return new Revue(0,titre,"",0,"",0);
		
	}
	
	
	public static Revue saisir_periodicite() {
		Scanner sc = new Scanner(System.in);	
		System.out.println("veuillez saisir la périodicité");
		int idp = sc.nextInt();		
		return new Revue(0,"","",0,"",idp);	
	}
	
	
	
	
	
	
	
	

	
	
	
	
}
