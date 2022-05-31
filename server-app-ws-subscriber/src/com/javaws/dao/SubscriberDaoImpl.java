package com.javaws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.javaws.entities.Subscriber;
import com.sgi.jdbc.DBManager;



public class SubscriberDaoImpl implements IDao<Subscriber> {

	public static final String DB_IN = "db_intelligent_network";	

	@Override
	public void create(Subscriber subscriber) throws Exception {
		Connection connection = DBManager.getConnection(DB_IN) ;

		String query = "Insert Into T_Subscribers (nom,numero,adresse,activated) values (?,?,?,?)";

		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setString(1, subscriber.getNom());
		preparedStatement.setString(2, subscriber.getNumero());
		preparedStatement.setString(3, subscriber.getAdresse());
		preparedStatement.setBoolean(4, false);

		preparedStatement.execute();
		
		connection.close();
	}

	@Override
	public Subscriber read(int id) throws Exception {
		Subscriber subscriber = null;
		
		Connection connection = DBManager.getConnection(DB_IN) ;

	    String query = "Select * From T_Subscribers Where id = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setInt(1, id);
	    
	    ResultSet resultSet = preparedStatement.executeQuery();
	    	    	    
	    if (resultSet.next()) {
	    	subscriber = new Subscriber (id, 
	        		resultSet.getString("nom"), 
	        		resultSet.getString("numero"),
	        		resultSet.getString("adresse"),
	        		resultSet.getBoolean("activated"));
	    }

	    connection.close();
	    
		return subscriber;
	}
	
	public Subscriber readByNumero(String numero) throws Exception {
		Subscriber subscriber = null;
		
		Connection connection = DBManager.getConnection(DB_IN) ;

	    String query = "Select * From T_Subscribers Where numero = ?";
	    PreparedStatement preparedStatement = connection.prepareStatement(query);
	    preparedStatement.setString(1, numero);
	    
	    ResultSet resultSet = preparedStatement.executeQuery();
	    	    	    
	    if (resultSet.next()) {
	    	subscriber = new Subscriber (resultSet.getInt("id"), 
	        		resultSet.getString("nom"), 
	        		numero,
	        		resultSet.getString("adresse"),
	        		resultSet.getBoolean("activated"));
	    }

	    connection.close();
	    
		return subscriber;
	}

	@Override
	public void update(Subscriber subscriber) throws Exception {
		Connection connection = DBManager.getConnection(DB_IN) ;

	    String query = "Update T_Subscribers Set nom=?, numero=?, adresse=?, activated=? Where id=?";

	    PreparedStatement prepareStatement = connection.prepareStatement(query);
	        
	    prepareStatement.setString(1, subscriber.getNom());
	    prepareStatement.setString(2, subscriber.getNumero());
	    prepareStatement.setString(3, subscriber.getAdresse());
	    prepareStatement.setBoolean(4, subscriber.isActivated());
	    prepareStatement.setInt(5, subscriber.getId());
	       
	    prepareStatement.execute();
	    
	    connection.close();
	}

	@Override
	public void delete(Integer id) throws Exception {
		Connection connection = DBManager.getConnection(DB_IN) ;

		String query = "Delete From T_Subscribers Where id=?";
	       
		PreparedStatement preparedStatement = connection.prepareStatement(query);

		preparedStatement.setInt(1, id);
		preparedStatement.execute();
		
		connection.close();
	}

	@Override
	public List<Subscriber> list() throws Exception {
		Connection connection = DBManager.getConnection(DB_IN) ;

		List<Subscriber> subscribers = new ArrayList<>();
		String query = "Select * From T_Subscribers";

		PreparedStatement prepareStatement = connection.prepareStatement(query);
		ResultSet resultSet = prepareStatement.executeQuery();

		while (resultSet.next()) {
			
			int id = resultSet.getInt("id");
			String nom = resultSet.getString("nom");
			String numero = resultSet.getString("numero");
			String adresse = resultSet.getString("adresse");
			boolean activated = resultSet.getBoolean("activated");
			
			Subscriber subscriber = new Subscriber (id, nom, numero, adresse, activated);
			
			subscribers.add(subscriber);
		}
		
		connection.close();
		
		return subscribers;
	}

}