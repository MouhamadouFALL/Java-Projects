package com.javaws.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.javaws.dao.UserDaoImpl;
import com.javaws.entities.User;

@WebService (name="AuthenticationWS")
public class WSAuthentification {

	@WebMethod
	public boolean authentifier (@WebParam(name="login") String login, 
			@WebParam(name="password") String password) {
			
			try {
				UserDaoImpl dao = new UserDaoImpl();				
				User user = dao.readByLoginPassword(login, password);
				if (user != null) return true;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			return false;
	}
}
