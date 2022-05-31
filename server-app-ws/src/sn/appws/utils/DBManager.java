/**
 * 
 */
package sn.appws.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * @author nabyFall
 *
 */
public class DBManager {

	private static Connection connection = null;
	
	public static Connection getConnection() throws Exception {
		
		try {
			// chargement du Driver mysql jdbc
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// Ouvrir la connexion
			String urlConnection = "jdbc:mysql://localhost:3306/dbusers?serverTimezone=UTC";
			String user = "root";
			String password = "";
			connection = DriverManager.getConnection(urlConnection, user, password);
			
			return connection;
		}
		catch(ClassNotFoundException e) {
			throw new Exception("Driver class not found : '" + e.getMessage() + "'. ");
		}
		catch(SQLException sqle) {
			throw new Exception("Error : Unable to open connection with database : " + sqle.getMessage());
		}
		
	}
}
