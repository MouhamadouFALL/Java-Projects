package sn.boom.javaws.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import sn.boom.javaws.entities.Subscriber;
import sn.boom.sgi.jdbc.DBManager;

public class SubscriberDaoImpl implements IDao<Subscriber> {

	@Override
	public void create(Subscriber obj) throws Exception {
		
		Connection connection = DBManager.getConnection();
		
		String query = "Insert Into t_subscribers(nom, numero, adresse, activated) values(?, ?, ?, ?)";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, obj.getNom());
		preparedStatement.setString(2, obj.getNumero());
		preparedStatement.setString(3, obj.getAdresse());
		preparedStatement.setBoolean(4, obj.getActivated());
		
		preparedStatement.execute();
		
		connection.close();
		
	}

	@Override
	public void update(Subscriber obj) throws Exception {
		
		Connection connection = DBManager.getConnection();
		
		String query = "Update t_subscribers Set nom=?, numero=?, adresse=?, activated=? Where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setString(1, obj.getNom());
		preparedStatement.setString(2, obj.getNumero());
		preparedStatement.setString(3, obj.getAdresse());
		preparedStatement.setBoolean(4, obj.getActivated());
		preparedStatement.setInt(5, obj.getId());
		
		preparedStatement.execute();
		
		connection.close();
	}

	@Override
	public Subscriber read(Integer id) throws Exception {
		
		Connection connection = DBManager.getConnection();
		
		String query = "Select * From t_subscribers Where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		ResultSet result = preparedStatement.executeQuery();
		
		if (result.first()) {
			
			Subscriber subscriber = new Subscriber(
					result.getInt("id"), 
					result.getString("nom"), 
					result.getString("numero"), 
					result.getString("adresse"),
					result.getBoolean("activated")
					);
			
			return subscriber;
		}
		else 
			return new Subscriber();
		
	}

	@Override
	public List<Subscriber> list() throws Exception {
		
		List<Subscriber> subscribers = new ArrayList<>();

		Connection connection = DBManager.getConnection();
		
		String query = "Select * From t_subscribers";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		
		ResultSet result = preparedStatement.executeQuery();
		
		while (result.next()) {
			
			int identifiant = result.getInt("id");
			String nom = result.getString("nom");
			String numero = result.getString("numero");
			String adresse = result.getString("adresse");
			Boolean activated = result.getBoolean("activated");
			
			Subscriber subscriber = new Subscriber(identifiant, nom, numero, adresse, activated);
			
			subscribers.add(subscriber);
			
		}
		
		return subscribers;
		
	}

	@Override
	public void delete(Integer id) throws Exception {
		
		Connection connection = DBManager.getConnection();
		
		String query = "Delete From t_subscribers Where id=?";
		PreparedStatement preparedStatement = connection.prepareStatement(query);
		preparedStatement.setInt(1, id);
		
		preparedStatement.execute();
		
		connection.close();
		
	}

}
