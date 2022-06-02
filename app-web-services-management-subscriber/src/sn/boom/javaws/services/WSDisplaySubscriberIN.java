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
@WebService(name="DisplaySubscriberINWS")
public class WSDisplaySubscriberIN {
	//70 845 62 67 // 77 824 48 37 // 76 029 89 74
	@WebMethod
	public Subscriber display(@WebParam(name="numero")String numero) {
		
		try {
			SubscriberDaoImpl dao = new SubscriberDaoImpl();
			Subscriber subscriber = dao.readByNumero(numero);
			
			if (subscriber != null) return subscriber;
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

}
