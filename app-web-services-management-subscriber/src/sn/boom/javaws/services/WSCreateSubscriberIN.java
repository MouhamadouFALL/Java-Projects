/**
 * 
 */
package sn.boom.javaws.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import sn.boom.javaws.dao.SubscriberDaoImpl;
import sn.boom.javaws.entities.Subscriber;
import sn.boom.javaws.error.ErrorCode;

/**
 * @author nabyFall
 *
 */
@WebService(name="CreateSubscriberINWS")
public class WSCreateSubscriberIN {

	@WebMethod
	public int create(
			@WebParam(name="nom") String nom, 
			@WebParam(name="numero")String numero, 
			@WebParam(name="adresse") String adresse) {
		
		
		try {
			SubscriberDaoImpl dao = new SubscriberDaoImpl();
			Subscriber subscriber = dao.readByNumero(numero);
			
			if (subscriber != null) 
				return ErrorCode.SUBSCRIBER_ALREADY_EXIST;
			
			subscriber = new Subscriber(nom, numero, adresse);
			dao.create(subscriber);
			
			return ErrorCode.SUCCESS;
		} 
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return ErrorCode.ERROR_WHILE_ACCESSING_DB;
	}
}
