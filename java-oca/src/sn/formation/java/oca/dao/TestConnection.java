package sn.formation.java.oca.dao;

import java.sql.Connection;

import javax.swing.JOptionPane;

public class TestConnection {

	public static void main(String[] args) {
		
		try (Connection connection = DBManager.getConnection()) {
			JOptionPane.showMessageDialog(null, "Connexion � la base de donn�es Ok!");
		}
		catch(Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}

	}

}
