package sn.formation.java.oca.exceptions;

import java.util.Scanner;

public class ExceptionThrowsDemo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		System.out.println("Entrer voter age :   ");
		int age = scan.nextInt();
		scan.close();
		
		try {
			validate(age);
		}
		catch (Exception e) {
			System.err.println("An error occured !" + e.getMessage());
		}
		
		System.out.println("Suite du programme ...");

	}
	
	
	public static void validate(int age) {
		
		if (age < 18)
			throw new IllegalArgumentException("Non elligible : " + age);
		else
			System.out.println("Elligible. Bonne chance");
	}

}
