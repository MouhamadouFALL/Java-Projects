package sn.formation.java.oca.tableaux;


public class TabArgs {

	public static void main(String[] args) {
		
		if (args.length > 0) {
			
			for (int i = 0; i < args.length; i++) {
				
				if (i == 2) {
					try {
						int age = Integer.parseInt(args[i]);
						System.out.println(" age : " + age);
					}
					catch (Exception e) {
						e.printStackTrace();
					}
				}
				else {
					System.out.println(" " + args[i]);
				}
			}
		}
		else {
			System.out.println(" Entrer des arguments");
		}

	}

}
