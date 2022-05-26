package sn.formation.java.oca.exceptions;

import java.util.Scanner;

public class ExceptionDemo {
	

	public static void main(String[] args) {
		
		// celle-ci va générer une Exception de type  : ArrayIndexOutOfBoundsException, 
		// si on entre une indice qui depasse le tableau
		//test(); 
		
		// solution 1 : on analyse et anticipe les enventuelles erreurs
		//solutionIfElse();
		
		// ici on gère les eventuelles erreurs avec le bloc try {...} catch(ClassException e) {...}
		solutionTryCatch();
	}


	public static void test() {
		
		Scanner scan = new Scanner(System.in);
		
		double[] tab = {1.2, 5};
		int index;
		
		System.out.println("Entrer l'indeice de la cellule : ");
		index = scan.nextInt();
		
		System.out.println("Tableau["+index+"] = " + tab[index]);
		
	}
	
	
	private static void solutionIfElse() {
		
		Scanner scan = new Scanner(System.in);
		
		double[] tab = {1.2, 5};
		int index;
		
		System.out.println("Entrer l'indeice de la cellule : ");
		index = scan.nextInt();
		
		if (index >= 0 && index < 2)
			System.out.println("Tableau["+index+"] = " + tab[index]);
		else
			System.err.println("Indice incorrecte !");
		
	}

	
	private static void solutionTryCatch() {
		
		Scanner scan = new Scanner(System.in);
		
		double[] tab = {1.2, 5};
		int index;
		
		System.out.println("Entrer l'indeice de la cellule : ");
		index = scan.nextInt();
		
		try {
			System.out.println("Tableau["+index+"] = " + tab[index]);
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.err.println("Indice incorrect : " + e.getMessage());
		}
	}

}
