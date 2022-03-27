package sn.formation.java.oca.tableaux;

public class TabTwoDimension {

	public static void main(String[] args) {

		int[][] matrice = new int[3][4];
		
		for (int i = 0; i < matrice.length; i++) {
			for (int j = 0; j < matrice[i].length; j++) {
				matrice[i][j] = i + j + 1;
				System.out.print(" " + matrice[i][j] + " |");
			}
			
			System.out.println("");
		}
		
		System.out.println("");
		System.out.println("");
		
		
		int[][] mat1 = {{9,8,7,6}, {5,4,3,2}, {1,2,3,4}};
		
		for (int i = 0; i < mat1.length; i++) {
			for (int j = 0; j < mat1[i].length; j++) {
				mat1[i][j] = i + j + 1;
				System.out.print(" " + mat1[i][j] + " |");
			}
			
			System.out.println("");
		}
	}

}
