package banque;

import banque.Exceptions.BanqueExceptionSeuil;

public class CompteASeuil extends Compte {

	private double seuil;
	
	public CompteASeuil() {
		this(0,0,0);
	}

	public CompteASeuil(int numero, double solde, double seuil) {
		super(numero, solde);
		this.setSeuil(seuil);
	}

	public double getSeuil() {
		return seuil;
	}

	public void setSeuil(double seuil) {
		this.seuil = seuil;
	}

	@Override
	public void retirer(double montant) throws BanqueExceptionSeuil {
		
		double soldeActuel = this.getSolde();
		double seuil = this.getSeuil();
		
		if ( soldeActuel - montant >= seuil ) {
			super.retirer(montant);
		} else {
			throw new BanqueExceptionSeuil("Retrait refusé: dépassement du seuil");
		}
	}
	
	
	@Override
	public String toString() {
		String str = super.toString();
		return str + ", seuil= " + this.getSeuil();
	}
	
	
	
}
