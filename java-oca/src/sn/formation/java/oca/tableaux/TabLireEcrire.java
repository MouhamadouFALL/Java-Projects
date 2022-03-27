package sn.formation.java.oca.tableaux;

import java.util.ArrayList;
import java.util.Date;

public class TabLireEcrire {

	public static void main(String[] args) {
		
		int[] tabInt = {12, 13, 14, 15};
		
		// Lire / read
		System.out.println(" " + tabInt[2]);
		
		// write / Ecrire
		tabInt[3] = 20;
		System.out.println(" " + tabInt[3]);
		
		System.out.println("-------------------------------- Tableau dynamique -----------------------");
		
		ArrayList tabArr = new ArrayList();
		
		// writte
		tabArr.add("Welcome");
		tabArr.add(92);
		tabArr.add(76l);
		tabArr.add(new Date());
		
		// Lire
		System.out.println(" Taille du tableau Arr: " + tabArr.size());
		System.out.println(" " + tabArr.get(3));

	}

}
