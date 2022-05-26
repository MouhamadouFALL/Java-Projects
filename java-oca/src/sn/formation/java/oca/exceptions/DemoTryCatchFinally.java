package sn.formation.java.oca.exceptions;

public class DemoTryCatchFinally {

	public static void main(String[] args) {
		
		int[] tabInt = new int[2];
		
		try {
			System.out.println("tentative d'acces � un " 
					+ " indice inexistant du tab : " + tabInt[3]);
		} 
		catch (ArrayIndexOutOfBoundsException e) {
			System.err.println("Crash du programme : " + e.getClass() + " indice : " + e.getMessage());
		}
		finally {
			System.out.println("\nBloc Finally ex�cut� systematiquement. (error ou pas)!");
		}

	}

}
