package sn.umapp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCConnection {

	private static JDBCConnection instance = new JDBCConnection();
	private Connection connection;
	private JDBCConnection() {}
	/*public Connection open () throws UMADBException {
	if (connection != null) return connection;
	try {
	Class.forName ("com.mysql.cj.jdbc.Driver");
	connection = DriverManager.getConnection("jdbc:mysql://localhost:3308/umsjdbc?serverTimezone=UTC", 
	"root", "");
	return connection;
	} catch (ClassNotFoundException e) {
		e.printStackTrace();
	}
	//throw new UMADBException("ERROR:" + e.getClass() + ":Le driver JDBC est introuvable !");
	} //catch (SQLException sqle) {
	//throw new UMADBException("ERROR:" + sqle.getClass() + ":" + sqle.getMessage());
	}*/
}
