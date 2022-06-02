/**
 * 
 */
package sn.boom.javaws.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import sn.boom.javaws.dao.UserDaoImpl;

/**
 * @author nabyFall
 *
 */
@WebService(name="AuthentificationWS")
public class WSAuthentificaion {

	@WebMethod
	public boolean authentifier(@WebParam(name="login") String login, 
			@WebParam(name="password") String password) {
		
		try {
			UserDaoImpl user = new UserDaoImpl();
			user.readByLoginPassword(login, password);
			if (user != null) return true;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}
}
