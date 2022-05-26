package sn.formation.java.oca.exceptions;

public class Calcul {

	public static void main(String[] args) {
		
		try {
			beginProcess();
			
			long result = somme(-1);
			System.out.println("Somme entiers : " + result);
			
		}
		catch (StackOverflowError e) {
			System.err.println("Error sur les piles : " + e);
		}
		finally {
			endProcess();
		}

	}
	
	
	static long somme(long n) {
		if ( n==1 ) {
			return 1;
		}
		else {
			return n + somme(n - 1);
		}
	}
	
	static void beginProcess() {
		System.out.println("[ Debut du programme ...");
	}
	
	static void endProcess() {
		System.out.println(" ... Fin du programme]");
	}

}
