package sn.formation.java.oca.exceptions;

public class CalculV2 {
	
public static void main(String[] args) {
		
		try {
			beginProcess();
			
			long result = somme(-1);
			System.out.println("Somme entiers : " + result);
			
		}
		catch (IllegalArgumentException e) {
			System.err.println("Argument non valide : " + e);
		}
		finally {
			endProcess();
		}

	}
	
	
	static long somme(long n) throws IllegalArgumentException {
		
		if ( n<=0 ) throw new IllegalArgumentException();
		
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
