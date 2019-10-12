package metier;

import java.util.Scanner;

import factory.DAOFactory;

public class Client {
	private int id;
	private String nom;
	private String prenom;
	private String no_rue;
	private String voie;
	private String code_postal;
	private String ville;
	private String pays;
	
	public Client(int id, String nom, String prenom, String no_rue, String voie, String code_postal, String ville, String pays) {
		this.setId(id);
		this.setNom(nom);
		this.setPrenom(prenom);
		this.setNo_rue(no_rue);
		this.setVoie(voie);
		this.setCode_postal(code_postal);
		this.setVille(ville);
		this.setPays(pays);	
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
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getNo_rue() {
		return no_rue;
	}
	public void setNo_rue(String no_rue) {
		this.no_rue = no_rue;
	}
	public String getVoie() {
		return voie;
	}
	public void setVoie(String voie) {
		this.voie = voie;
	}
	public String getCode_postal() {
		return code_postal;
	}
	public void setCode_postal(String code_postal) {
		this.code_postal = code_postal;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}

	@Override
	public String toString() {
		return "Client [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", no_rue=" + no_rue + ", voie=" + voie
				+ ", code_postal=" + code_postal + ", ville=" + ville + ", pays=" + pays + "]";
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
		Client other = (Client) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	
	public static void saisir_action(DAOFactory factory) {
		Scanner sc = new Scanner(System.in);
		int Input=0;
		System.out.println("choix de l'opération :1 pour créer, 2 pour modifier, 3 pour supprimer, 4 pour trouver par id, 5 pour trouver par nom et prénom, 6 pour trouver par adresse, 7 pour trouver par code postal, 8 pour trouver par ville, 9 pour trouver par pays, 10 pour quitter  ");
		do {
		Input = sc.nextInt();
			
		switch(Input) {
		case 1 : 
			boolean i = factory.getClientDAO().create(Client.saisir_creation());
			if (i!= true) {
				System.out.println("l'opération a rencontré un problème");
			}
			break;
		case 2 :
			i = factory.getClientDAO().update(Client.saisir_modification());
			if (i!= true) {
				System.out.println("l'opération a rencontré un problème");
			}
			break;
		
		case 3 :
			i = factory.getClientDAO().delete(Client.saisir_id());
			if (i!= true) {
				System.out.println("l'opération a rencontré un problème");
			}
			break;
		
		case 4 :
			System.out.println(factory.getClientDAO().getById(Client.saisir_id().getId()));
			break;
		
		case 5 :
			System.out.println(factory.getClientDAO().GetByNomPrenom(Client.saisir_nom_prenom()));
			break;
		
		case 6 :
			System.out.println(factory.getClientDAO().GetByAdresse(Client.saisir_adresse()));
			break;
		
		case 7 :
			System.out.println(factory.getClientDAO().GetByCode_Postal(Client.saisir_code_postal()));
			break;
			
		case 8 :
			System.out.println(factory.getClientDAO().GetByVille(Client.saisir_ville()));
			break;
		
		case 9 :
			System.out.println(factory.getClientDAO().GetByPays(Client.saisir_pays()));
			break;
		}
		}while((Input>10)||(Input<0));
	}
	

	
	public static Client saisir_creation() {
		
		Client c1 = Client.saisir_nom_prenom();
		
		Client c2 = Client.saisir_adresse();
		
		Client c3 = Client.saisir_code_postal();
		
		Client c4 = Client.saisir_ville();
		
		Client c5 = Client.saisir_pays();
		
		
		return new Client(0,c1.getNom(),c1.getPrenom(),c2.getNo_rue(),c2.getVoie(),c3.getCode_postal(),c4.getVille(),c5.getPays());
		
	}
	
	public static Client saisir_modification() {
		Client c1 = Client.saisir_id();
		Client c2 = Client.saisir_creation();
		c2.setId(c1.getId());
		return c2;
		
	}
	
	public static Client saisir_id() {
		Scanner sc = new Scanner(System.in);	
		System.out.println("veuillez saisir l'id de l'élément");
		int id = sc.nextInt();	
		return new Client(id,"","","","","","","");
		
	}
	
	public static Client saisir_nom_prenom() {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("veuillez saisir le nom");
		String nom= sc.nextLine();
		
		System.out.println("veuillez saisir le prenom");
		String prenom = sc.nextLine();
		return new Client(0,nom,prenom,"","","","","");
	}
	
	public static Client saisir_adresse() {
		Scanner sc = new Scanner(System.in);
		System.out.println("veuillez saisir le numero");
		String numero= sc.nextLine();
		
		System.out.println("veuillez saisir la voie");
		String voie = sc.nextLine();
		return new Client(0,"","",numero,voie,"","","");
	}
	
	public static Client saisir_code_postal() {
		Scanner sc = new Scanner(System.in);
		System.out.println("veuillez saisir le code postal");
		String code_postal= sc.nextLine();
		return new Client(0,"","","","",code_postal,"","");
	
	}
	
	public static Client saisir_ville() {
		Scanner sc = new Scanner(System.in);
		System.out.println("veuillez saisir la ville");
		String ville= sc.nextLine();
		return new Client(0,"","","","","",ville,"");
	
	}
	
	public static Client saisir_pays() {
		Scanner sc = new Scanner(System.in);
		System.out.println("veuillez saisir le pays");
		String pays= sc.nextLine();
		return new Client(0,"","","","","","",pays);
	
	}
	

}
