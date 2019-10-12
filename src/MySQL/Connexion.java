package MySQL;
import java.sql.*;

public class Connexion {
	
	public  static Connection creeConnexion() {
		String url = "jdbc:mysql://devbdd.iutmetz.univ-lorraine.fr:3306/ledeux2u_RevuesOnLine?serverTimezone=Europe/Paris";
		String login = "ledeux2u_appli";
		String pwd = "31802662";
		Connection maConnexion = null;
		try { 
			maConnexion = (Connection) DriverManager.getConnection(url, login, pwd);
			} 
		catch (SQLException sqle) 
		{
			System.out.println("Erreur connexion" + sqle.getMessage());
			}
		return maConnexion;
	}




}