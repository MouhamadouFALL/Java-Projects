package sn.umapp.db;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class HibernateConnection {
	
	private static HibernateConnection instance = new HibernateConnection();
	
	private Session session = null;
	private SessionFactory sfactory = null;
	
	private HibernateConnection() {
		
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();
		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();
		
		// Creating Hibernate Session Factory Instance
		sfactory = meta.getSessionFactoryBuilder().build();
		
		// Creting the Hibernate's Session Object 
		session = sfactory.openSession();
	}
	
	
	public Session getSession() {
		if (session == null)
			new HibernateConnection();
		return session;
	}
	
	public void closeSession() {
		if (session != null) {
			session.close();
			session = null;
		}
	}
	
	public void closeSessionFactory() {
		if (sfactory != null) {
			closeSession();
			sfactory.close();
			sfactory = null;
		}
	}
	
	public static HibernateConnection getInstance() {
		return instance;
	}

}
