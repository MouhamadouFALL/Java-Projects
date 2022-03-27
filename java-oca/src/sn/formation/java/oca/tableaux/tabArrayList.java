package sn.formation.java.oca.tableaux;

public class tabArrayList {

	public static void main(String[] args) { 
		
		java.util.ArrayList tabArrayList = new java.util.ArrayList(); 
		tabArrayList.add("Bonsoir");
		tabArrayList.add(92);
		tabArrayList.add(new java.util.Date());
		
		int index = 0;
		while (index < tabArrayList.size()) {
			   
			System.out.println(" " + tabArrayList.get(index));
			index++;
		}
		
		
		java.util.ArrayList<Integer> tabInt = new java.util.ArrayList<Integer>();
		tabInt.add(12);
		tabInt.add(92);
		tabInt.add(10);
		
		for (Integer a : tabInt) {
			System.out.println(" " + a);
		}

	}

}
