package com.sgov.app.bankmodules;

import javax.swing.JOptionPane;

public class BankModules implements ITransfertRequest, IBankService {

	@Override
	public void effectuerVirement(String numeroCompteSrc, String numeroCompteDest) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Effectuer un virement",
				"Virement effectu� avec succes", JOptionPane.OK_OPTION);

	}

	@Override
	public void importerFichierVirement(String path) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Importer un fichier",
				"BankModules:fichier Import� effectu� avec succes", JOptionPane.OK_OPTION);

	}

	@Override
	public String genererFichierRetour() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "G�n�rer un fichier",
				"BankModules:fichier g�n�rer effectu� avec succes", JOptionPane.OK_OPTION);

		return "C:\\emplacement\\";
	}

}
