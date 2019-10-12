package metier;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import factory.DAOFactory;

public class Abonnement {

		private int id_client;
		private int id_revue;
		private LocalDate date_debut;
		private LocalDate date_fin;
	
		public Abonnement(int id_client,int id_revue,String date_debut,String date_fin){
			this.setId_client(id_client);
			this.setId_revue(id_revue);
			
			DateTimeFormatter formatage = DateTimeFormatter.ofPattern("dd/MM/yyyy");
				
			
			this.setDate_debut(LocalDate.parse(date_debut, formatage));
			this.setDate_fin(LocalDate.parse(date_fin, formatage));
		}
		
		public Abonnement(int id_client,int id_revue,LocalDate date_debut,LocalDate date_fin){
			this.setId_client(id_client);
			this.setId_revue(id_revue);
			this.setDate_debut(date_debut);
			this.setDate_fin(date_fin);
		}



		public int getId_client() {
			return id_client;
		}



		public void setId_client(int id_client) {
			this.id_client = id_client;
		}



		public int getId_revue() {
			return id_revue;
		}



		public void setId_revue(int id_revue) {
			this.id_revue = id_revue;
		}







		public LocalDate getDate_debut() {
			return date_debut;
		}



		public void setDate_debut(LocalDate date_debut) {
			this.date_debut = date_debut;
		}



		public LocalDate getDate_fin() {
			return date_fin;
		}



		public void setDate_fin(LocalDate date_fin) {
			this.date_fin = date_fin;
		}



		@Override
		public String toString() {
			return "Abonnement [id_client=" + id_client + ", id_revue=" + id_revue + ", date_debut=" + date_debut
					+ ", date_fin=" + date_fin + "]";
		}

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + id_client;
			result = prime * result + id_revue;
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
			Abonnement other = (Abonnement) obj;
			if (id_client != other.id_client)
				return false;
			if (id_revue != other.id_revue)
				return false;
			return true;
		}

		public static void saisir_action(DAOFactory factory) {
			Scanner sc = new Scanner(System.in);
			int Input=0;
			System.out.println("choix de l'opération :1 pour créer, 2 pour modifier, 3 pour supprimer, 4 pour trouver par id client et id revue, 5 pour trouver par id client, 6 pour trouver par id revue, 7 pour trouver par date de début, 8 pour trouver par date de fin, 9 pour retourner en arrière");
			do {
			Input = sc.nextInt();
				
			switch(Input) {
			case 1 : 
				boolean i = factory.getAbonnementDAO().create(Abonnement.saisir_tout());
				if (i!= true) {
					System.out.println("l'opération a rencontré un problème");
				}
				break;
			case 2 :
				i = factory.getAbonnementDAO().update(Abonnement.saisir_tout());
				if (i!= true) {
					System.out.println("l'opération a rencontré un problème");
				}
				break;
			
			case 3 :
				i = factory.getAbonnementDAO().delete(Abonnement.saisir_id2());
				if (i!= true) {
					System.out.println("l'opération a rencontré un problème");
				}
				break;
			
			case 4 :
				System.out.println(factory.getAbonnementDAO().GetByClientEtRevue(Abonnement.saisir_id2()));
				break;
			
			case 5 :
				System.out.println(factory.getAbonnementDAO().GetByIDClient(Abonnement.saisir_id_client()));
				break;
			
			case 6 :
				System.out.println(factory.getAbonnementDAO().GetByIDRevue(Abonnement.saisir_id_revue()));
				break;
			
			case 7 :
				System.out.println(factory.getAbonnementDAO().GetByDateDebut(Abonnement.saisir_date_debut()));
				break;
			
			case 8 :
				System.out.println(factory.getAbonnementDAO().GetByDateFin(Abonnement.saisir_date_fin()));
				break;
			
			
			}
			}while((Input>9)||(Input<0));
		}


		public static Abonnement saisir_tout() {
			Abonnement a1 = Abonnement.saisir_id2();
			Abonnement a3 = Abonnement.saisir_date_debut();
			a1.setDate_debut(a3.getDate_debut());
			a3= Abonnement.saisir_date_fin();
			a1.setDate_fin(a3.getDate_fin());
			return a1;
		}
		

		public static Abonnement saisir_id2() {
			Abonnement a1 = Abonnement.saisir_id_client();
			Abonnement a2 = Abonnement.saisir_id_revue();
			a1.setId_revue(a2.getId_revue());
			return a1;
		}

		public static Abonnement saisir_id_client() {
			Scanner sc = new Scanner(System.in);
			System.out.println("saisir l'id client");
			int idc = sc.nextInt();
			return new Abonnement(idc,0,"01/01/0000","01/01/0000");
	
		}
		
		public static Abonnement saisir_id_revue() {
			Scanner sc = new Scanner(System.in);
			System.out.println("saisir l'id de la revue");
			int idr = sc.nextInt();
			return new Abonnement(0,idr,"01/01/0000","01/01/0000");
		}
		
		public static Abonnement saisir_date_debut() {
			Scanner sc = new Scanner(System.in);
			System.out.println("saisir l'a date de début au format dd/mm/yyyy");
			String date = sc.nextLine();
			return new Abonnement(0,0,date,"01/01/0000");
		}

		public static Abonnement saisir_date_fin() {
			Scanner sc = new Scanner(System.in);
			System.out.println("saisir l'a date de début au format dd/mm/yyyy");
			String date = sc.nextLine();
			return new Abonnement(0,0,"01/01/0000",date);
	
		}
		
}
