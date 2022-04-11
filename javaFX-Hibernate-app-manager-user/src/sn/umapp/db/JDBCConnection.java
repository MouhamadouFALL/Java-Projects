package sn.umapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	private static JDBCConnection instance = new JDBCConnection();
	private Connection connection;
	
	private JDBCConnection() { }
	
	
	public Connection open () throws UMADBException {
		
		//if (connection != null) return connection;
	
		try {
			
			Class.forName ("com.mysql.cj.jdbc.Driver");
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/umajdbc?serverTimezone=UTC", "root", "");
			
			return connection;
			
		} 
		catch (ClassNotFoundException e) {
			throw new UMADBException("ERROR : " + e.getClass() + " : Le driver JDBC est introuvable !");
		}
		catch (SQLException sqle) {
			throw new UMADBException("ERROR : " + sqle.getClass() + " : " + sqle.getMessage());
		}
		
	}
	
	
	public void close() throws UMADBException {
		try {
			if (connection != null) connection.close();
		}
		catch (SQLException e) {
			throw new UMADBException("ERROR : " + e.getCause() + " : " + e.getMessage());
		}
	}
	
	public static JDBCConnection getInstance() {
		return instance;
	}
	
}
