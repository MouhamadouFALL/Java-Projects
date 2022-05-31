package sn.boom.javaws.entities;

public class User {

	private Integer id;
	private String login;
	private String password;
	
	public User() {
		this(-1, "none", "none");
	}
	
	public User(String login, String password) {
		this.login = login;
		this.password = password;
	}
	
	public User(Integer id, String login, String password) {
		this(login, password);
		
		setId(id);
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	
}
