package sn.umapp;

import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import sn.umapp.db.UMADBException;
import sn.umapp.db.dao.HibernateUserDaoImpl;
import sn.umapp.db.dao.IUserDao;
import sn.umapp.db.dao.UserDaoImpl;
import sn.umapp.model.Role;
import sn.umapp.model.User;

public class DataSource {
	// une liste observable utilisateur
	private ObservableList<User> users = FXCollections.observableArrayList();
	
	//UserDaoImpl dao;
	//HibernateUserDaoImpl dao;
	IUserDao dao;
	
	public DataSource() throws UMADBException {
		
		dao = new HibernateUserDaoImpl();
		//dao = new UserDaoImpl();
		List<User> users = dao.list();
		this.users.addAll(users);
		
	}
	
	public ObservableList<User> getUsers() {
		return users;
	}
	
	public void add(User user) throws UMADBException {
		dao.create(user);
		this.users.add(user);
	}
	
	public void deleteUser(Integer id) throws UMADBException {
		dao.delete(id);
	}
	
	public void update(User user) throws UMADBException {
		dao.update(user);
	}

}
