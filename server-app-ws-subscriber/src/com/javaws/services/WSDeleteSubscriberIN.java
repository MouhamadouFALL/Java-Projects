package com.javaws.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.javaws.dao.SubscriberDaoImpl;
import com.javaws.entities.Subscriber;
import com.javaws.interfaces.ErrorCode;

@WebService (name="DeleteSubscriberINWS")
public class WSDeleteSubscriberIN {

	@WebMethod
	public int delete (
			@WebParam(name="numero") String numero) {

			try {
				SubscriberDaoImpl dao = new SubscriberDaoImpl();				
				Subscriber subscriber = dao.readByNumero(numero);
				if (subscriber == null) return ErrorCode.SUBSCRIBER_NOT_FOUND;
				else {
					dao.delete(subscriber.getId());
					return ErrorCode.SUCCESS;
				}
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
			return ErrorCode.ERROR_WHILE_ACCESSING_DB;
	}
}
