package sn.formation.java.oca.interfaces;

public class User implements Comparable<User> {

	private String nom;
	private String prenom;
	
	public User() {}
	
	public User(String nom) {
		this.nom = nom;
	}
	
	
	@Override
	public int compareTo(User user) {
		// TODO Auto-generated method stub
		return this.nom.compareTo(user.nom);
	}

}
