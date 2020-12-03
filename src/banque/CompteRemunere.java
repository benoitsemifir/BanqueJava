package banque;

public class CompteRemunere extends Compte {
	
	private double taux;

	public CompteRemunere() {
		this(0,0,0);
	}

	public CompteRemunere(int numero, double solde, double taux) {
		super(numero, solde);
		this.setTaux(taux);
	}

	public double getTaux() {
		return taux;
	}

	public void setTaux(double taux) {
		if(taux >= 0 && taux <=1 ) {			
			this.taux = taux;
		} else {
			System.err.println("Le taux doit être entre 0 et 1");
		}
	}
	
	public double calculerInterets() {
		return this.taux * this.getSolde();
	}
	
	/**
	 * Permet d'appeler statiquement calculerInteret (sans instancier d'objet CompteRemunere)
	 * @param compteR Le compte rémunéré sur lequel calcuer les interets.
	 * @return interets Les interets calculés.
	 */
	public static double calculerInteret(CompteRemunere compteR) {
		double interets = compteR.getSolde() * compteR.getTaux();
		return interets;
	}
	
	public void verserInterets() {
		double interets = this.calculerInterets();
		this.ajouter(interets);
	}
	
	@Override
	public String toString() {
		String str = super.toString();
		return str + ", taux=" + this.taux;
	}

}
