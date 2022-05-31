package com.javaws.services;


import java.util.ArrayList;
import java.util.List;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.javaws.dao.UserDaoImpl;
import com.javaws.entities.User;

@WebService(name="UserWS")
public class WSUser {

	@WebMethod
	public User read (@WebParam(name="id") int id) {
			
			try {
				UserDaoImpl dao = new UserDaoImpl();
				return dao.read(id);
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

			return new User();
	}
	
	@WebMethod
	public boolean create (@WebParam(name="login") String login, 
			@WebParam(name="password") String password) {
			
			try {
				UserDaoImpl dao = new UserDaoImpl();
				User user = new User (login, password);
				dao.create(user);
				
				return true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

			return false;
	}
	
	@WebMethod
	public List<User> list () {
			try {
				UserDaoImpl dao = new UserDaoImpl();
				return dao.list();
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

			return new ArrayList<User>();
	}
}