package com.sgov.app.services;

import com.sgov.app.bankmodules.BankModules;
import com.sgov.app.bankmodules.IBankService;
import com.sgov.app.bankmodules.ITransfertRequest;

public class Service implements IService {
	private ITransfertRequest trfRequest;
	private IBankService bankService;
	
	

	public Service() {
		bankService = new BankModules();
		trfRequest = new BankModules();
	}

	@Override
	public void virement(String srcCompte, String destCompte) {
		// TODO Auto-generated method stub
		bankService.effectuerVirement(srcCompte, destCompte);

	}

	@Override
	public void importer(String path) {
		// TODO Auto-generated method stub
		trfRequest.importerFichierVirement(path);
	}

	@Override
	public String getFichierRetour() {
		// TODO Auto-generated method stub
		
		String path = trfRequest.genererFichierRetour();
		return path;
	}

}
