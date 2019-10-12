package launch;


import java.text.ParseException;
import java.util.Scanner;

import factory.DAOFactory;
import factory.Persistance;
import metier.Abonnement;
import metier.Client;
import metier.Periodicite;
import metier.Revue;

public class Test {

	public static void main(String[] args) throws ParseException {
		
		int Input;
		Scanner sc = new Scanner(System.in);
		DAOFactory daos = DAOFactory.getDAOFactory(Persistance.MYSQL);
		do {
			System.out.println("Veuillez choisir sur quoi interagir : 1 pour revue, 2 pour abonnement, 3 pour client, 4 pour périodicité, 5 pour changer de type de stockage entre MySQL et ListeMemoire, 6 pour quitter");
			Input=sc.nextInt();
			if(Input==1) {
				Revue.saisir_action(daos);
			}
			else if(Input==2) {
				Abonnement.saisir_action(daos);
			}
			else if(Input==3) {
				Client.saisir_action(daos);
			}
			else if(Input==4) {
				Periodicite.saisir_action(daos);
			}
			else if(Input==5) {
				daos = DAOFactory.ChangeDAOFactory(daos);
			}
		}while(Input != 6);
		
	}

}