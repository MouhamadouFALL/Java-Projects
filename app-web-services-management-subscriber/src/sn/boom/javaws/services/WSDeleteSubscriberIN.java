/**
 * 
 */
package sn.boom.javaws.services;

import javax.jws.WebService;

import sn.boom.javaws.dao.SubscriberDaoImpl;
import sn.boom.javaws.entities.Subscriber;
import sn.boom.javaws.error.ErrorCode;

import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 * @author nabyFall
 *
 */
@WebService(name="DeleteSubscriberINWS")
public class WSDeleteSubscriberIN {

	@WebMethod
	public int deleteSubscriber(@WebParam(name="numero")String numero) {
		
		try {
			SubscriberDaoImpl dao = new SubscriberDaoImpl();
			Subscriber subscriber = dao.readByNumero(numero);
			
			if (subscriber == null)
				return ErrorCode.SUBSCRIBER_NOT_FOUND;
			
			//int identifiant = subscriber.getId();
			dao.delete(subscriber.getId());
			return ErrorCode.SUCCESS;
		} 
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return ErrorCode.ERROR_WHILE_ACCESSING_DB;
	}
}
