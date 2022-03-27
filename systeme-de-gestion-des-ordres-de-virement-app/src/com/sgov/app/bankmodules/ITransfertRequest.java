package com.sgov.app.bankmodules;

public interface ITransfertRequest {
	void importerFichierVirement(String path);
	String genererFichierRetour();
}
