package sn.formation.java.oca.exceptions.cheminementExceptions;

import java.util.Scanner;

public class Chemin {
	
	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		int n;
		System.out.println(" Donner un entier : ");
		n = scan.nextInt();
		scan.close();
		
		try {
			System.out.println("Debut premier bloc try ");
			if (n!=0) throw new Except(n);
			System.out.println("Fin premier bloc try ");
		}
		catch(Except e) {
			System.err.println("Catch 1 - n = " + e.n);
		}
		
		System.out.println("");
		System.out.println("Suite du programme ...");
		System.out.println("");
		
		try {
			System.out.println("Debut second bloc try ");
			if (n!=1) throw new Except(n);
			System.out.println("Fin second bloc try ");
		}
		catch (Except e) {
			System.err.println("Catch 2 - n = " + e.n);
			System.exit(-1);
		}
		
		System.out.println("");
		System.out.println("Fin du programme ...");
		System.out.println("");
		
	}
}
