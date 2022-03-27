package com.sgouv.service;

public interface Iservice {
	
	void virement (String srcCompte, String desCompte);
	void importer (String path);
	String getFichierRetour();
}
