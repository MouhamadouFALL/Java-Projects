/**
 * 
 */
package sn.boom.javaws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sn.boom.javaws.entities.User;
import sn.boom.sgi.jdbc.DBManager;

/**
 * @author nabyFall
 *
 */
public class UserDaoImpl implements IDao<User> {
	
	public static final String DB_IN = "dbusers";

	@Override
	public void create(User obj) throws Exception {
		// obtenir un object connection
		Connection connection = DBManager.getConnection(DB_IN);
		
		// Definir la requete
		String query = "Insert Into t_users(login, password) values(?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, obj.getLogin());
		preparedStatement.setString(2, obj.getPassword());
		
		// executer la requete
		preparedStatement.execute();
		
		connection.close();
		
	}

	@Override
	public User read(Integer id) throws Exception {
		User user = null;
		
		Connection connection = DBManager.getConnection(DB_IN);
		
		String query = "Select * From t_users Where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		ResultSet result = preparedStatement.executeQuery();
		if (result.first()){
			user = new User(
					id, 
					result.getString("login"), 
					result.getString("password")
					);
		}
		
		connection.close();
		
		return user;
	}
	
	public User readByLoginPassword(String login, String password) throws Exception{
		User user = null;
		
		Connection connection = DBManager.getConnection(DB_IN);
		
		String query = "Select * From t_users Where login=? and password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, login);
		preparedStatement.setString(2, password);
		
		ResultSet result = preparedStatement.executeQuery();
		if (result.first()){
			user = new User(
					result.getInt("id"), 
					result.getString("login"), 
					result.getString("password")
					);
		}
		
		connection.close();
		
		return user;
	}

	@Override
	public void update(User obj) throws Exception {
		
		Connection connection = DBManager.getConnection(DB_IN);
		
		String query = "Update t_users Set login=?, pqssword=? Where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, obj.getLogin());
		preparedStatement.setString(2, obj.getPassword());
		preparedStatement.setInt(3, obj.getId());
		
		preparedStatement.execute();
		
		connection.close();
	}

	@Override
	public void delete(Integer id) throws Exception {
		
		Connection connection = DBManager.getConnection(DB_IN);
		
		String query = "Delete From t_users Where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		preparedStatement.execute();
		
		connection.close();
		
	}

	@Override
	public List<User> list() throws Exception {
		
		Connection connection = DBManager.getConnection(DB_IN);
		
		List<User> users = new ArrayList<>();
		
		String query = "Select * From t_users";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		ResultSet result = preparedStatement.executeQuery();
		while (result.next()) {
			User user = new User(
					result.getInt("id"), 
					result.getString("login"), 
					result.getString("password")
					);
			
			users.add(user);
		}
		
		connection.close();
		
		return users;
	}

}
