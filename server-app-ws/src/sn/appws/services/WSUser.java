/**
 * 
 */
package sn.appws.services;

import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import sn.appws.dao.UserDaoImpl;
import sn.appws.entities.User;

/**
 * @author nabyFall
 *
 */
@WebService(name="UserWS")
public class WSUser {
	
	@WebMethod
	public User readUser(@WebParam(name="id")int id) {
		
		try {
			UserDaoImpl dao = new UserDaoImpl();
			User user = dao.read(id);
			if (user != null) return user;
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return new User();
	}
	
	@WebMethod
	public List<User> listUsers(){
		
		try {
			UserDaoImpl dao = new UserDaoImpl();
			List<User> users = dao.list();
			
			if(users != null) return users;
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return new ArrayList<User>();
	}
	
	@WebMethod
	public int createUser(@WebParam(name="login") String login, 
			@WebParam(name="password") String password) {
		
		try {
			UserDaoImpl dao = new UserDaoImpl();
			
			if (login != null && password != null) {
				User user = new User();
				user.setLogin(login);
				user.setPassword(password);
				
				dao.create(user);
				
				return 0;
			}
			
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
		return 1;
	}
	
	@WebMethod
	public void updateUser(@WebParam(name="id") int id, 
			@WebParam(name="login") String login, 
			@WebParam(name="password") String password) {
		
		try {
			UserDaoImpl dao = new UserDaoImpl();
			User user = dao.read(id);
			if (user != null) {
				user.setLogin(login);
				user.setPassword(password);
				
				dao.update(user);
			}
			
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
	}
	
	@WebMethod
	public void deleteUser(@WebParam(name="id") int id) {
		
		try {
			UserDaoImpl dao = new UserDaoImpl();
			dao.delete(id);
		}
		catch(Exception e) {
			System.err.println(e.getMessage());
		}
		
	}

}
