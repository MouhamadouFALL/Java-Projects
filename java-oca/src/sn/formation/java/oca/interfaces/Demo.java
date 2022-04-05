package sn.formation.java.oca.interfaces;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		User user1 = new User("Jules");
		User user2 = new User("Bouh");
		
		System.out.println(user2.compareTo(user1));
		
		String nom = " ";
		System.out.println(nom.equals(null));
		System.out.println(nom.isEmpty());
		System.out.println(nom.length());

	}

}
