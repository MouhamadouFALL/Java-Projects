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
@WebService(name="DeactivatedSubscriberINWS")
public class WSDeactivatedSubscriberIN {
	
	@WebMethod
	public int deactivate(@WebParam(name="numero")String numero) {
		
		try {
			
			SubscriberDaoImpl dao = new SubscriberDaoImpl();
			Subscriber subscriber = dao.readByNumero(numero);
			
			if (subscriber == null)
				return ErrorCode.SUBSCRIBER_NOT_FOUND;
			
			else if (!subscriber.getActivated())
				return ErrorCode.SUBSCRIBER_ALREADY_DEACTIVATED;
			
			else {
				subscriber.setActivated(false);
				dao.update(subscriber);
				return ErrorCode.SUCCESS;
			}
				
			
		} 
		catch (Exception e) {
			System.err.println(e.getMessage());
		}
		
		return ErrorCode.ERROR_WHILE_ACCESSING_DB;
	}

}
