package com.sgouv.bankmodules;

import javax.swing.JOptionPane;

public class BankModules implements IBankService, ITransfertRequest {

	@Override
	public void importerFichierVirement(String path) {
		JOptionPane.showMessageDialog(null, " importer un fichier ", " BankModules: fichier importe effectue avec succes  ", JOptionPane.OK_OPTION);
	}

	@Override
	public String genererFichierRetour() {
		
		JOptionPane.showMessageDialog(null, "G�n�rer un fichier", "BankModules:fichier g�n�rer effectu� avec succes", JOptionPane.OK_OPTION);
		return "C:\\Users\\nabyFall\\Desktop";
	}

	@Override
	public void effectuerVirement(String numeroComptSrc, String numeroCompteDes) {
		JOptionPane.showConfirmDialog(null, " effectuer un virement  ", " Virement effectuer avec succes ! ", JOptionPane.OK_OPTION);
	}
}
