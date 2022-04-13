package sn.umapp.db.dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.hibernate.Session;
import org.hibernate.Transaction;

import sn.umapp.db.HibernateConnection;
import sn.umapp.db.UMADBException;
import sn.umapp.model.User;

public class HibernateUserDaoImpl implements IUserDao {

	@Override
	public void create(User user) throws UMADBException {
		
		try {
		Session session = HibernateConnection.getInstance().getSession();
		
		// Creating transaction object
		Transaction transaction = session.beginTransaction();
		
		session.save(user);
		
		// transaction is commited to DataBase
		transaction.commit();
		}
		catch (Exception e) {
			throw new UMADBException("ERROR : " + e.getClass() + " : " + e.getMessage());
		}
	}

	@Override
	public User read(Integer id) throws UMADBException {
		User user = null;
		try {
			
			Session session = HibernateConnection.getInstance().getSession();
			user = session.find(User.class, id);
		}
		catch (Exception e) {
			throw new UMADBException("ERROR : " + e.getClass() + " : " + e.getMessage());
		}
		
		return user;
	}

	@Override
	public void update(User user) throws UMADBException {
		
		try {
			Session session = HibernateConnection.getInstance().getSession();
			
			// Creating Transaction Object
			Transaction transaction = session.beginTransaction();
			
			session.update(user);
			
			// transaction is commited to database
			transaction.commit();
		}
		catch (Exception e) {
			throw new UMADBException("ERROR : " + e.getClass() + " : " + e.getMessage());
		}
		
	}

	@Override
	public void delete(Integer id) throws UMADBException {

		try {
			Session session = HibernateConnection.getInstance().getSession();
			
			Transaction transaction = session.beginTransaction();
			
			User u = read(id);
			if (u != null)
				session.delete(u);
			
			transaction.commit();
		}
		catch (Exception e) {
			throw new UMADBException("ERROR : " + e.getClass() + " : " + e.getMessage());
		}
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<User> list() throws UMADBException {
		
		List<User> users = new ArrayList<>();
		
		try {
			Session session = HibernateConnection.getInstance().getSession();
			
			Query query = session.createQuery("From User");
			users = query.getResultList();
		}
		catch (Exception e) {
			throw new UMADBException("ERROR : " + e.getClass() + " : " + e.getMessage());
		}
		
		return users;
	}

}
