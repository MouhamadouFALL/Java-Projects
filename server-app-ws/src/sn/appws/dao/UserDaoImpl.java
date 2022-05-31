package sn.appws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sn.appws.entities.User;
import sn.appws.utils.DBManager;

public class UserDaoImpl implements IDao<User> {

	@Override
	public void create(User obj) throws Exception {
		
		Connection connection = DBManager.getConnection();
		
		String query = "Insert Into t_users(login, password) Values(?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, obj.getLogin());
		preparedStatement.setString(2, obj.getPassword());
		
		preparedStatement.executeUpdate();
		
		preparedStatement.close();
		
	}

	@Override
	public User read(Integer id) throws Exception {
		
		User user = new User();
		
		Connection connection = DBManager.getConnection();
		
		String query = "Select * From t_users Where id = ?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		ResultSet result = preparedStatement.executeQuery();
		
		if (result.first()) {
			
			String login = result.getString("login");
			String password = result.getString("password");
			
			user.setId(id);
			user.setLogin(login);
			user.setPassword(password);

		}
		
		connection.close();
		
		return user;
	}

	@Override
	public List<User> list() throws Exception {
		
		List<User> users = new ArrayList<>();
		User user = new User();
		
		// obtenir un objet connection
		Connection connection = DBManager.getConnection();
		
		String query = "Select * From t_users";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		ResultSet result = preparedStatement.executeQuery();
		
		while(result.next()) {
			
			int id = result.getInt("id");
			String login = result.getString("login");
			String password = result.getString("password");
			
			user.setId(id);
			user.setLogin(login);
			user.setPassword(password);
			
			users.add(user);
		}
		
		connection.close();
		
		return users;
	}

	@Override
	public void update(User obj) throws Exception {
		
		Connection connection = DBManager.getConnection();
		
		String query = "Update t_users Set login=?, password=? Where id=?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(3, obj.getId());
		preparedStatement.setString(1, obj.getLogin());
		preparedStatement.setString(2, obj.getPassword());
		
		preparedStatement.execute();
		
		connection.close();
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		
		Connection connection = DBManager.getConnection();
		
		String query = "Delete From t_users Where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		
		connection.close();
	}
	
	public User readByLoginPassword(String login, String password) throws Exception {
		
		User user = new User();
		
		Connection connection = DBManager.getConnection();
		String query = "Select * From t_users Where login=?, password=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		preparedStatement.setString(1, login);
		preparedStatement.setString(2, password);
		
		ResultSet result = preparedStatement.executeQuery();
		
		if(result.first()) {
			
			user.setId(result.getInt("id"));
			user.setLogin(result.getString("login"));
			user.setPassword(result.getString("password"));
		}
		
		connection.close();
		
		return user;
	}

}
