package sn.boom.javaws.consoleui;

import java.util.List;
import java.util.Scanner;

import sn.boom.javaws.dao.IDao;
import sn.boom.javaws.dao.SubscriberDaoImpl;
import sn.boom.javaws.entities.Subscriber;

public class Demo {

	public static void main(String[] args) {
		
		Scanner scan = new Scanner(System.in);
		
		//System.out.println("entrer votre nom : ");
		//String nom = scan.nextLine();
		//System.out.println("entrer votre nunero : ");
		//String numero = scan.nextLine();
		//System.out.println("entrer votre adresse : ");
		//String adresse = scan.nextLine();
		///System.out.println("voulez vous activer le numero ? ");
		//String resp = scan.nextLine();
		
		
		
		//Subscriber subscriber = new Subscriber(nom, numero, adresse);
		
		//if (resp.compareTo("o") == 0 || resp.compareTo("O") == 0)
			//subscriber.setActivated(true);
		
		//try {
			
			//IDao<Subscriber> dao = new SubscriberDaoImpl();
			//dao.create(subscriber);
			
		//} //catch (Exception e) {
			//e.printStackTrace();
		//}
		
		//------------------------- Lire un subscriber puis plusieurs ------------------
		

		//System.out.println("entrer le numeor du subscriber : ");
		//String numero = scan.nextLine();
		
		//try {
			
			//Subscriber subscriber = new Subscriber();
			
			//IDao<Subscriber> dao = new SubscriberDaoImpl();
			
			//subscriber = dao.read(numero);
			
			//System.out.println("Nom du subscriber : " + subscriber.getNom());
			//System.out.println("Numero du subscriber : " + subscriber.getNumero());
			//System.out.println("Adresse du subscriber : " + subscriber.getAdresse());
			
		//} catch (Exception e) {
			//e.printStackTrace();
		//}
		
		
		/*System.out.println("******************** List subscribers ********************** ");
		System.out.println("");
		try {
		
			IDao<Subscriber> dao = new SubscriberDaoImpl();
		
			List<Subscriber> subscribers = dao.list();
		
			for (Subscriber subscriber : subscribers) {
				System.out.println("Nom du subscriber : " + subscriber.getNom());
				System.out.println("Numero du subscriber : " + subscriber.getNumero());
				System.out.println("Adresse du subscriber : " + subscriber.getAdresse());
				System.out.println("Etat d'activation : " + subscriber.getActivated());
				System.out.println("--------------------------------------------------------");
			}
		
		} 
		catch (Exception e) {
			e.printStackTrace();
		}*/
		//--------------------------------------------- Modifier un Subscriber --------------------
		/*
		System.out.println("entrer le numeor du subscriber : ");
		String numero = scan.nextLine();
		System.out.println("entrer le nouveau nom du subscriber : ");
		String nom = scan.nextLine();
		System.out.println("Voulez vous l'activer  : O | N");
		String res = scan.nextLine();
		
		try {
			IDao<Subscriber> dao = new SubscriberDaoImpl();
			Subscriber subscriber = dao.read(numero);
			
			if (subscriber != null) {
				subscriber.setNom(nom);
				if (res.equals("O") || res.equals("o"))
					subscriber.setActivated(true);
			}
			
			dao.update(subscriber);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/

		//--------------------------------------------- Supprimer un Subscriber --------------------
				
		System.out.println("Entrer le numeor du subscriber a supprimer : ");
		Integer identifiant = Integer.parseInt(scan.nextLine());
		
		try {
			IDao<Subscriber> dao = new SubscriberDaoImpl();
			dao.delete(identifiant);
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scan.close();
	}

	
}
