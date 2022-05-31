package com.javaws.entities;

public class User {
	private int id;
	private String login;
	private String password;

	public User() {
		this(-1, "none", "none");
	}

	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}

	public User(int id, String login, String password) {
		this(login, password);
		
		this.setId(id);
	}

	public int getId() {
		return id;
	}
	
	public void setId(int id) {
		this.id = id;
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

	@Override
	public String toString() {
		return "User [id=" + id + ", login=" + login + ", password=" + password + "]";
	}
}
