package com.sgouv.bankmodules;

public interface ITransfertRequest {
	
	void importerFichierVirement(String path);
	String genererFichierRetour();
	
}
