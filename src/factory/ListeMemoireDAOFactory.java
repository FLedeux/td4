package factory;

import dao.AbonnementDAO;
import dao.ClientDAO;
import dao.PeriodiciteDAO;
import dao.RevueDAO;
import liste_memoire.ListeMemoireAbonnementDAO;
import liste_memoire.ListeMemoireClientDAO;
import liste_memoire.ListeMemoirePeriodiciteDAO;
import liste_memoire.ListeMemoireRevueDAO;

public class ListeMemoireDAOFactory extends DAOFactory {

	@Override
	public ClientDAO getClientDAO() {
		return ListeMemoireClientDAO.getInstance();
	}

	@Override
	public RevueDAO getRevueDAO() {
		return ListeMemoireRevueDAO.getInstance();
	}

	@Override
	public PeriodiciteDAO getPeriodiciteDAO() {
		return ListeMemoirePeriodiciteDAO.getInstance();
	}

	@Override
	public AbonnementDAO getAbonnementDAO() {
		return ListeMemoireAbonnementDAO.getInstance();
	}

}
