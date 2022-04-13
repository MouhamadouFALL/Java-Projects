package sn.umapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

@Entity (name="User")
public class User {

	@Id
	@GeneratedValue (strategy=GenerationType.IDENTITY)
	@Column (name="id_user")
	private Integer idUser;
	
	private String nom;
	private String prenom;
	private String email;
	private String telephone;
	private String login;
	private String password;
	private String role;
	
	
	public User(int idUser, String nom, String prenom, String email, String telephone, String login,
			String password, String role) {
		
		this.idUser = idUser;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.login = login;
		this.password = password;
		this.role = role;
	}
	
	
	public User(String nom, String prenom, String email,
			String telephone, String login, String password, String role) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.login = login;
		this.password = password;
		this.role = role;
	}

	public User(String nom, String prenom, String email, 
			String telephone, String role) {
		
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.telephone = telephone;
		this.login = nom+"."+prenom;
		this.password = "passer";
		this.role = role;
	}
	
	public User() {
		this("", "", "", "", "SIMPLE USER");
		this.login = "";
		this.password = "";
	}
	
	
	//////////////////////////// genered getters and setters ///////////////////////////////////

	public Integer getIdUser() {
		return idUser;
	}


	public void setIdUser(Integer idUser) {
		this.idUser = idUser;
	}


	public String getNom() {
		return nom;
	}


	public void setNom(String nom) {
		this.nom = nom;
	}


	public String getPrenom() {
		return prenom;
	}


	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTelephone() {
		return telephone;
	}


	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}


	public String getLogin() {
		return login;
	}


	public void setLogin(String login) {
		this.login = login;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public String getRole() {
		return role;
	}


	public void setRole(String role) {
		this.role = role;
	}
	
	
}
