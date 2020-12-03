package banque;

import banque.Exceptions.BanqueExceptionSeuil;

public class Compte {
	
	private double solde;
	private int numero;

	public Compte() {
		this(0,0);
	}
	
	public Compte(int numero, double solde) {
		this.setNumero(numero);
		this.solde = solde;
	}

	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if(numero >= 0) {			
			this.numero = numero;
		}
	}
	
	/**
	 * Ajouter un montant d'argent a ajouter au solde
	 * @param montant Le montant a ajouter
	 */
	public void ajouter(double montant) {
		this.solde += montant;
	}
	
	public void retirer(double montant) throws BanqueExceptionSeuil {
		this.solde -= montant;
	}

	@Override
	public String toString() {
		return this.getClass() +" numero=" + this.numero + ", solde=" + this.solde + "€";
	}

}
