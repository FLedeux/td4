package factory;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.PeriodiciteDAO;
import dao.RevueDAO;

public abstract class DAOFactory {

	public static DAOFactory getDAOFactory(Persistance cible) {
		DAOFactory daoF = null;
		switch (cible) {
			case MYSQL:
				daoF = new MySQLDAOFactory();
				break;
			case ListeMemoire : 
				daoF = new ListeMemoireDAOFactory();
				break;
				}
		return daoF;
		}
	
	public static DAOFactory ChangeDAOFactory(DAOFactory change) {
		if(change.getClass()==MySQLDAOFactory.class) {
			return new ListeMemoireDAOFactory();
		}
		else {
			return new MySQLDAOFactory();
		}
		
	}
	
	public abstract ClientDAO getClientDAO();
	public abstract RevueDAO getRevueDAO();
	public abstract PeriodiciteDAO getPeriodiciteDAO();
	public abstract AbonnementDAO getAbonnementDAO();
	
}
