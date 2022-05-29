package sn.formation.java.oca.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBManager {

	private static Connection connection = null;
	
	public static Connection getConnection() throws Exception{
		
		try {
			// Chargement du driver jdbc mysql 
			Class.forName("com.mysql.cj.jdbc.Driver");
			
			// ouverture de la connexion
			DriverManager.getConnection("jdbc:mysql://localhost/dbcontact", "root", "");
			
			return connection;
		}
		catch(ClassNotFoundException e) {
			throw new Exception("Driver class not found : '" + e.getMessage() + "' !");
		}
		catch(SQLException e) {
			throw new Exception("Error : Enable to open connection with database !");
		}
		
	}
}
