package sn.umapp.model;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class User {

	private Integer idUser;
	
	private StringProperty nom;
	private StringProperty prenom;
	private StringProperty email;
	private StringProperty telephone;
	private StringProperty login;
	private StringProperty password;
	private StringProperty role;
	
	public User(int idUser, String nom, String prenom, String email, String telephone, String login,
			String password, String role) {
		
		this.idUser = idUser;
		this.nom = new SimpleStringProperty(nom);
		this.prenom = new SimpleStringProperty(prenom);
		this.email = new SimpleStringProperty(email);
		this.telephone = new SimpleStringProperty(telephone);
		this.login = new SimpleStringProperty(login);
		this.password = new SimpleStringProperty(password);
		this.role = new SimpleStringProperty(role);
	}
	
	
	public User(Integer idUser, String nom, String prenom, String email,
			String telephone, String role) {
		
		this(idUser, nom, prenom, email, telephone, (prenom.trim().toLowerCase() + "." + nom.trim().toLowerCase()), "passer", role);
		
	}


	public User(String nom, String prenom, String email, 
			String telephone, String role) {
		this(null, nom, prenom, email, telephone, role);
	}


	public User() {
		this("", "", "", "", Role.SIMPLE_USER.getValue());
		this.login = new SimpleStringProperty("");
		this.password = new SimpleStringProperty("");
	}
	
	
	//////////////////////////// genered getters and setters ///////////////////////////////////

	public Integer getIdUser() {
		return idUser;
	}


	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}


	public StringProperty getNom() {
		return nom;
	}


	public void setNom(StringProperty nom) {
		this.nom = nom;
	}


	public StringProperty getPrenom() {
		return prenom;
	}


	public void setPrenom(StringProperty prenom) {
		this.prenom = prenom;
	}


	public StringProperty getEmail() {
		return email;
	}


	public void setEmail(StringProperty email) {
		this.email = email;
	}


	public StringProperty getTelephone() {
		return telephone;
	}


	public void setTelephone(StringProperty telephone) {
		this.telephone = telephone;
	}


	public StringProperty getLogin() {
		return login;
	}


	public void setLogin(StringProperty login) {
		this.login = login;
	}


	public StringProperty getPassword() {
		return password;
	}


	public void setPassword(StringProperty password) {
		this.password = password;
	}


	public StringProperty getRole() {
		return role;
	}


	public void setRole(StringProperty role) {
		this.role = role;
	}
	
	
}
