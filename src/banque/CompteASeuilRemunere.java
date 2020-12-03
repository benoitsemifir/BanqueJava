package banque;

import banque.Exceptions.BanqueExceptionSeuil;
import banque.Interfaces.ICompteASeuil;

public class CompteASeuilRemunere extends CompteRemunere implements ICompteASeuil {

	double seuil;

	public CompteASeuilRemunere() {
		this(0,0,0,0);
	}

	public CompteASeuilRemunere(int numero, double solde, double taux, double seuil) {
		super(numero, solde, taux);
		this.seuil = seuil;
	}


	public double getSeuil() {
		return this.seuil;
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

}
