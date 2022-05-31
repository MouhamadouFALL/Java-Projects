package com.javaws.services;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import com.javaws.dao.SubscriberDaoImpl;
import com.javaws.entities.Subscriber;

@WebService (name="DisplaySubscriberINWS")
public class WSDisplaySubscriberIN {

	@WebMethod
	public Subscriber display (
			@WebParam(name="numero") String numero) {

			try {
				SubscriberDaoImpl dao = new SubscriberDaoImpl();				
				return dao.readByNumero(numero);
				
			} catch (Exception e) {
				System.err.println(e.getMessage());
			}

			return null;
	}
}
