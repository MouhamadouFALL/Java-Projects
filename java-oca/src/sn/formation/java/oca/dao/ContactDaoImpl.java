package sn.formation.java.oca.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class ContactDaoImpl implements IDao<Contact> {

	@Override
	public void create(Contact entity) throws Exception {
		
		try (Connection connection = DBManager.getConnection()) {
			
			String query = "Insert Into t_contacts(nom, prenom, telephone, email) values(?, ?, ?, ?)";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			preparedStatement.setString(1, entity.getNom());
			preparedStatement.setString(2, entity.getPrenom());
			preparedStatement.setString(3, entity.getTelephone());
			preparedStatement.setString(4, entity.getEmail());
			
			//
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public Contact read(int id) throws Exception {
		
		try (Connection connection = DBManager.getConnection()) {
			
			String query = "Select * from t_contacts where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			ResultSet result = preparedStatement.executeQuery();
			
			if (result.first()) {
				Integer identifiant = result.getInt("id");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				String telephone = result.getString("telephone");
				String email = result.getString("email");
				
				Contact contact = new Contact();
				contact.setNom(nom);
				contact.setPrenom(prenom);
				contact.setTelephone(telephone);
				contact.setEmail(email);
				
				return contact;
			}
			else {
				return null;
			}
			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
		
	}

	@Override
	public List<Contact> list() throws Exception {
		
		List<Contact> contacts = new ArrayList<>();
		
		try(Connection connection = DBManager.getConnection()) {
			
			String query = "Select * From t_contacts";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			
			ResultSet result = preparedStatement.executeQuery();
			
			while(result.next()) {
				Integer identifiant = result.getInt("id");
				String nom = result.getString("nom");
				String prenom = result.getString("prenom");
				String telephone = result.getString("telephone");
				String email = result.getString("email");
				
				Contact contact = new Contact();
				contact.setNom(nom);
				contact.setPrenom(prenom);
				contact.setTelephone(telephone);
				contact.setEmail(email);
				
				
				// Add in collection contacts
				contacts.add(contact);				
			}
			
			return contacts;
			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}

	}

	@Override
	public void update(Contact entity) throws Exception {
		
		try (Connection connection = DBManager.getConnection()) {
			
			String query = "Update t_contacts Set nom=?, prenom=?, telephone=?, email=? Where id=?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, entity.getNom());
			preparedStatement.setString(2, entity.getPrenom());
			preparedStatement.setString(3, entity.getTelephone());
			preparedStatement.setString(4, entity.getEmail());
			preparedStatement.setInt(5, entity.getId());
			
			preparedStatement.executeUpdate();
			
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	@Override
	public void delete(int id) throws Exception {
		
		try(Connection connection = DBManager.getConnection()){
			
			String query = "Delete From t_contatcs Where id = ?";
			PreparedStatement preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, id);
			
			preparedStatement.executeUpdate();
		}
		catch(Exception e) {
			throw new Exception(e.getMessage());
		}
	}

}
