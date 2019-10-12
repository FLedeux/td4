package MySQL;

import dao.ClientDAO;
import metier.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class MySQLClientDAO implements ClientDAO{

	
private static MySQLClientDAO instance;
	
	private MySQLClientDAO() {}

	public static MySQLClientDAO getInstance() {
		if (instance==null) {
			instance = new MySQLClientDAO();
		}
		return instance;
	}
	
	@Override
	public Client getById(int id) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("Select * From Client Where id_client=?");
			requete.setInt(1,id);
			ResultSet res = requete.executeQuery();
			
			if(res.next()){
				Client client = new Client(res.getInt("id_client"),res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays"));

				if (requete != null)requete.close();
				if (laConnexion != null)laConnexion.close();
				return client;			
			}
			else {
				if (requete != null)requete.close();
				if (laConnexion != null)laConnexion.close();
				throw (new IllegalArgumentException("Aucun objet ne poss�de cet identifiant"));
			}

		}
			catch (SQLException sqle) {
				throw (new IllegalArgumentException(sqle.getMessage()));

				}
	}

	@Override
	public boolean create(Client client) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("insert into Client (nom, prenom, no_rue, voie, code_postal, ville, pays) values(?,?,?,?,?,?,?)", Statement.RETURN_GENERATED_KEYS);
			requete.setString(1, client.getNom());
			requete.setString(2, client.getPrenom());
			requete.setString(3, client.getNo_rue());
			requete.setString(4, client.getVoie());
			requete.setString(5, client.getCode_postal());
			requete.setString(6, client.getVille());
			requete.setString(7, client.getPays());

			int res = requete.executeUpdate();
			
			if (res == 1) {
				ResultSet key = requete.getGeneratedKeys();
				
				if(key.next()) client.setId(key.getInt(1));
			}
			if (requete != null)requete.close();
			
			if (laConnexion != null)laConnexion.close();
			
			return res==1; 
			}
			catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				return false;
			}
	}

	@Override
	public boolean update(Client client) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("update Client set nom=?,prenom=?,no_rue=?, voie=?,code_postal=?,ville=?,pays=?  where id_client=?");
			requete.setString(1, client.getNom());
			requete.setString(2, client.getPrenom());
			requete.setString(3, client.getNo_rue());
			requete.setString(4, client.getVoie());
			requete.setString(5, client.getCode_postal());
			requete.setString(6, client.getVille());
			requete.setString(7, client.getPays());
			requete.setInt(8, client.getId());
			
			int res = requete.executeUpdate();
			
			if (requete != null)requete.close();
			
			if (laConnexion != null)laConnexion.close();
			if(res<1) {
				throw (new IllegalArgumentException("Aucun objet ne poss�de cet identifiant"));
			}
			return res==1;
			}
			catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				return false;
				}
	}

	@Override
	public boolean delete(Client client) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("delete from Client where id_client=?");
			requete.setInt(1, client.getId());
			int res = requete.executeUpdate();
			if (requete != null)requete.close();
			
			if (laConnexion != null)laConnexion.close();
			if(res<1) {
				throw (new IllegalArgumentException("Aucun objet ne poss�de cet identifiant"));
			}
			return res==1;
			}
			catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				return false;
			}
	}

	@Override
	public ArrayList<Client> GetByNomPrenom(Client client) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("Select * From Client Where nom=? AND prenom=?");
			requete.setString(1,client.getNom());
			requete.setString(2, client.getPrenom());
			ResultSet res = requete.executeQuery();
			

			ArrayList<Client> Liste = new ArrayList<Client>();
			
			while (res.next()) {
				Liste.add(new Client(res.getInt("id_client"),res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays")));
				}
			if (requete != null)requete.close();
			if (laConnexion != null)laConnexion.close();
			return Liste;
			
			}
			catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				return null;
				}
	}

	@Override
	public ArrayList<Client> GetByAdresse(Client client) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("Select * From Client Where no_rue=? AND voie=?");
			requete.setString(1,client.getNo_rue());
			requete.setString(2, client.getVoie());
			ResultSet res = requete.executeQuery();
			
			ArrayList<Client> Liste = new ArrayList<Client>();
			
			while (res.next()) {
				Liste.add(new Client(res.getInt("id_client"),res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays")));
				}
			if (requete != null)requete.close();
			if (laConnexion != null)laConnexion.close();
			return Liste;
			
			}
			catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				return null;
				}
	}

	@Override
	public ArrayList<Client> GetByCode_Postal(Client client) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("Select * From Client Where code_postal=?");
			requete.setString(1,client.getCode_postal());
			ResultSet res = requete.executeQuery();
			
			ArrayList<Client> Liste = new ArrayList<Client>();
			
			while (res.next()) {
				Liste.add(new Client(res.getInt("id_client"),res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays")));
				}
			if (requete != null)requete.close();
			if (laConnexion != null)laConnexion.close();
			return Liste;
			
			}
			catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				return null;
				}
	}

	@Override
	public ArrayList<Client> GetByVille(Client client) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("Select * From Client Where ville=?");
			requete.setString(1,client.getVille());
			ResultSet res = requete.executeQuery();
			

			ArrayList<Client> Liste = new ArrayList<Client>();
			
			while (res.next()) {
				Liste.add(new Client(res.getInt("id_client"),res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays")));
				}
			if (requete != null)requete.close();
			if (laConnexion != null)laConnexion.close();
			return Liste;
			
			}
			catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				return null;
				}
	}

	@Override
	public ArrayList<Client> GetByPays(Client client) {
		try {
			Connection laConnexion = Connexion.creeConnexion();
			PreparedStatement requete = laConnexion.prepareStatement("Select * From Client Where pays=?");
			requete.setString(1,client.getPays());
			ResultSet res = requete.executeQuery();
			
			ArrayList<Client> Liste = new ArrayList<Client>();
			
			while (res.next()) {
				Liste.add(new Client(res.getInt("id_client"),res.getString("nom"),res.getString("prenom"),res.getString("no_rue"),res.getString("voie"),res.getString("code_postal"),res.getString("ville"),res.getString("pays")));
				}
			if (requete != null)requete.close();
			if (laConnexion != null)laConnexion.close();
			return Liste;
			
			}
			catch (SQLException sqle) {
				System.out.println("Pb select" + sqle.getMessage());
				return null;
				}
	}

}
