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
