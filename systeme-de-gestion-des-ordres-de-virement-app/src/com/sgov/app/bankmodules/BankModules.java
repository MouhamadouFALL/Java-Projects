package com.sgov.app.bankmodules;

import javax.swing.JOptionPane;

public class BankModules implements ITransfertRequest, IBankService {

	@Override
	public void effectuerVirement(String numeroCompteSrc, String numeroCompteDest) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Effectuer un virement",
				"Virement effectué avec succes", JOptionPane.OK_OPTION);

	}

	@Override
	public void importerFichierVirement(String path) {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Importer un fichier",
				"BankModules:fichier Importé effectué avec succes", JOptionPane.OK_OPTION);

	}

	@Override
	public String genererFichierRetour() {
		// TODO Auto-generated method stub
		JOptionPane.showMessageDialog(null, "Générer un fichier",
				"BankModules:fichier générer effectué avec succes", JOptionPane.OK_OPTION);

		return "C:\\emplacement\\";
	}

}
