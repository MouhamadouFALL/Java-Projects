package com.javaws.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.javaws.dao.SubscriberDaoImpl;
import com.javaws.entities.Subscriber;
import com.javaws.interfaces.ErrorCode;

@WebService (name="CreateSubscriberINWS")
public class WSCreateSubscriberIN {
	@WebMethod
	public int create (
			@WebParam(name="numero") String numero, 
			@WebParam(name="nom") String nom, 
			@WebParam(name="adresse") String adresse) {

			try {
				SubscriberDaoImpl dao = new SubscriberDaoImpl();				
				Subscriber subscriber = dao.readByNumero(numero);				
				if (subscriber != null) 
					return ErrorCode.SUBSCRIBER_ALREADY_EXIST;
				
				subscriber = new Subscriber (nom, numero, adresse);
				dao.create(subscriber);
				
				return ErrorCode.SUCCESS;
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}
			
			return ErrorCode.ERROR_WHILE_ACCESSING_DB;
	}
}