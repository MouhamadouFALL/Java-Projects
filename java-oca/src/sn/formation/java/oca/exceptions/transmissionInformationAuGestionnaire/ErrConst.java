package sn.formation.java.oca.exceptions.transmissionInformationAuGestionnaire;

public class ErrConst extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private int valeur;
	
	public ErrConst(int valeur) {
		this.valeur = valeur;
	}
	
	public int getValeur() {
		return valeur;
	}
}
