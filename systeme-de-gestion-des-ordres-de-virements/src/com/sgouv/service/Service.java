package com.sgouv.service;

import com.sgouv.bankmodules.BankModules;
import com.sgouv.bankmodules.IBankService;
import com.sgouv.bankmodules.ITransfertRequest;

public class Service implements Iservice {
	
	private ITransfertRequest transfertRes;
	private IBankService bankService;
	
	public Service() {
		bankService = new BankModules();
		transfertRes = new BankModules();
	}

	@Override
	public void virement(String srcCompte, String desCompte) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void importer(String path) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public String getFichierRetour() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
