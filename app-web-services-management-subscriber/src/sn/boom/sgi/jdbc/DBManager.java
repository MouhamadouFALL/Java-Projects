package sn.boom.sgi.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {
	
	private static Connection connection = null;
	
	public static Connection getConnection() throws Exception {
		String dbName = "dbusers";
		String dbUser = "root";
		String dbPassword = "";
		return getConnection(dbName, dbUser, dbPassword);
	}
	
	public static Connection getConnection(String dbName) throws Exception {
		String dbUser = "root";
		String dbPassword = "";
		return getConnection(dbName, dbUser, dbPassword);
	}
	
	public static Connection getConnection(String dbName, String dbUser, String dbPassword) throws Exception {
		
		try {
			// chargement du diver jdbc mysql
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			//Ouverture de la connexion
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+ dbName +"?serverTimezone=UTC", dbUser, dbPassword);
			
			return connection;
		}
		catch(ClassNotFoundException e) {
			throw new Exception("Driver class not found : '" + e.getMessage() + "' .");
		}
		catch(SQLException sqle) {
			throw new Exception("Error : Unable to open connection with databese " + sqle.getMessage());
		}
	}

}
