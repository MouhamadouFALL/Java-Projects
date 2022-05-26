package sn.formation.java.oca.exceptions.declenchementTraitement;

public class EntNat {
	
	private int n;
	
	public EntNat(int n) throws ErrConst {
		
		if (n < 0) throw new ErrConst();
		this.n = n;
		
	}
	
	public int getN() {
		return n;
	}

}
