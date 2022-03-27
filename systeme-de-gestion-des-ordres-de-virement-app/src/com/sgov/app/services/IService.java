package com.sgov.app.services;

public interface IService {
	void virement(String srcCompte, String destCompte);
	void importer(String path);
	String getFichierRetour();
}
