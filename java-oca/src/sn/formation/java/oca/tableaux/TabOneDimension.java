package sn.formation.java.oca.tableaux;

public class TabOneDimension {

	public static void main(String[] args) {
		
		int[] tab;
		
		tab = new int[5];
		
		for (int i = 0; i < tab.length; i++) {
			tab[i] = i + 2;
			
			System.out.println("tab[ " + i + " ] = " + tab[i]);
		}
		
		System.out.println("");
		
		int[] tab1 = {9, 8, 7, 6, 5}; // <==> int[] tab1 = new int[] {9, 8, 7, 6, 5};
		
		for (int i = 0; i < tab1.length; i++)
			System.out.println("tab[ " + i + " ] = " + tab1[i]);
	}
}
