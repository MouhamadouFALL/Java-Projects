package sn.umapp.db.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import sn.umapp.db.JDBCConnection;
import sn.umapp.db.UMADBException;
import sn.umapp.model.User;

public class UserDaoImpl implements IUserDao{

	@Override
	public void create(User user) throws UMADBException {
		
		String query = "insert into t_users (nom, prenom, email, telephone, login, password, role) values (?, ?, ?, ?, ?, ?, ?)";
		
		try {
			Connection conn = JDBCConnection.getInstance().open();
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setString(1, user.getNom().get());
			preparedStatement.setString(2, user.getPrenom().get());
			preparedStatement.setString(3, user.getEmail().get());
			preparedStatement.setString(4, user.getTelephone().get());
			preparedStatement.setString(5, user.getLogin().get());
			preparedStatement.setString(6, user.getPassword().get());
			preparedStatement.setString(7, user.getRole().get());
			
			// retourne un boolean
			Boolean res = preparedStatement.execute();
			
			// retourne un ResultSet
			//ResultSet resultset = preparedStatement.executeQuery();
			
			JDBCConnection.getInstance().close();
		} 
		catch (SQLException e) {
			throw new UMADBException("ERROR : " + e.getClass() + " : " + e.getMessage());
		}
	}

	@Override
	public User read(Integer id) throws UMADBException {
		
		String query = "select * from t_users where id=?";
		
		try {
			Connection conn = JDBCConnection.getInstance().open();
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			preparedStatement.setInt(1, id);
			
			ResultSet res = preparedStatement.executeQuery();
			
			User user = null;
			
			if (res.next()) {
				
				int idUser = res.getInt(1);
				String nom = res.getString(2);
				String prenom = res.getString(3);
				String email = res.getString(4);
				String telephone = res.getString(5);
				String login = res.getString(6);
				String password = res.getString(7);
				String role = res.getString(8);

				user = new User(idUser, nom, prenom, email, telephone, login, password, role);
			}
			
			return user;
		
		}
		catch (SQLException e) {
			throw new UMADBException("ERROR : " + e.getClass() + " : " + e.getMessage());
		}
	}

	@Override
	public void update(User user) throws UMADBException {
		
		String query = "update set nom=?, prenom=?";
		
	}

	@Override
	public void delete(Integer id) throws UMADBException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<User> list() throws UMADBException {
		
		String query = "select * from t_users";
		
		List<User> users = new ArrayList<User>();
		
		try {
			
			Connection conn = JDBCConnection.getInstance().open();
			PreparedStatement preparedStatement = conn.prepareStatement(query);
			
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while(resultSet.next()) {
				int idUser = resultSet.getInt("idUser");
				String nom = resultSet.getString("nom");
				String prenom = resultSet.getString(3);
				String email = resultSet.getString("email");
				String telephone = resultSet.getString("telephone");
				String login = resultSet.getString("login");
				String password = resultSet.getString("password");
				String role = resultSet.getString(8);
				
				User user = new User(idUser, nom, prenom, email, telephone, login, password, role);
				
				users.add(user);
				
			}
			
			return users;
		} 
		catch (SQLException e) {
			throw new UMADBException("ERROR : " + e.getClass() + " : " + e.getMessage());
		}
		
	}

}
