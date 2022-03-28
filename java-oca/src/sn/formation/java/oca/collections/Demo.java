package sn.formation.java.oca.collections;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class Demo {

	public static void main(String[] args) {
		
		Collection<String> fruits = new ArrayList<String>();
		
		fruits.add("mangue");
		fruits.add("orange");
		fruits.add("banane");
		fruits.add("pomme");
		fruits.add("raisins");
		
		// afficher la taille de la collections fruits
		System.out.println(" Taille fruits : " + fruits.size());
		
		System.out.println("============================================= interface fonctionnelle =================================");
		
		fruits.forEach(s -> System.out.println(s));
		
		System.out.println("============================================= Avec Iterator =================================");
		
		// Iterer sur la collection fruits
		Iterator<String> it = fruits.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		System.out.println("============================================== Iterations avec for each ===============================");
		// supprimer un fruits dans la collection fruits
		fruits.remove("mangue");
		
		// Iterer a nouveau sur la collection
		for (String fruit : fruits) {
			System.out.println(fruit);
		}
		
		System.out.println("================== Retirer un objet dans la collection enn cours de traitement =============================");
		
		// retirer un objet dans la collection au moment de l'iteration
		Collection<String> noms = new ArrayList<String>();
		
		noms.add("Jules");
		noms.add("Bouh");
		noms.add("Aliou");
		noms.add("Modou");
		noms.add("Doudou");
		noms.add("Boukki");
		
		Iterator<String> iterator = noms.iterator();
		
		while(iterator.hasNext()) {
			String s = iterator.next();
			if(s.equals("Boukki")) 
				iterator.remove();
			else 
				System.out.println(s);
		}

	}

}
