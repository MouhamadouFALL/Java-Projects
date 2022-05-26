package sn.formation.java.oca.exceptions.transmissionInformationAuGestionnaire;

public class DemoEntNat {

	public static void main(String[] args) {
		
		try {
			EntNat n1 = new EntNat(5);
			System.out.println(" n1 = " + n1.getN());
			EntNat n2 = new EntNat(-1);
			System.out.println(" n2 = " + n2.getN());
		}
		catch (ErrConst e) {
			System.err.println("*** Tentative construction naturel avec : "+e.getValeur()+" *** ");
			//System.out.println("*** erreur de construction ***");
			//System.exit(-1);
		}

	}

}
