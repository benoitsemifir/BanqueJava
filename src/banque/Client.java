package banque;

import java.util.Arrays;

public class Client {

	private String nom;
	private String prenom;
	private int age;
	private int numero;
	private Compte[] tabCompte;
	
	public Client() {
		this("","",0,0);
	}
	
	public Client(String nom, String prenom, int age, int numero) {
		this(nom, prenom, age, numero, new Compte[5]);
	}
	
	public Client(String nom, String prenom, int age, int numero, Compte[] comptes) {
		this.nom = nom;
		this.prenom = prenom;
		this.setAge(age);
		this.setNumero(numero);
		this.tabCompte = comptes;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		if(age>0 && age <= 120) {			
			this.age = age;
		}
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		if(numero >= 0) {			
			this.numero = numero;
		}
	}
	
	public Compte[] getTabCompte() {
		return tabCompte;
	}

	public void setTabCompte(Compte[] tabCompte) {
		this.tabCompte = tabCompte;
	}

	public void ajouterCompte(Compte compte) {
		for (int i = 0; i < this.tabCompte.length ; i++ ) {
			if(this.tabCompte[i] == null) {
				this.tabCompte[i] = compte;
				return;
			}
		}
		System.out.println("Le client a déja 5 comptes");
	}
	
	public Compte getCompte(int numeroCompte) {
		for(Compte compte : this.tabCompte) {
				if(compte != null && compte.getNumero() == numeroCompte) {
					return compte;
				}
		}
		System.out.println("Aucun compte avec ce numéro");
		return null;
	}

	@Override
	public String toString() {
		return "Client [numero=" + this.numero + ", nom=" + this.nom + ", prenom=" + this.prenom + ", age=" + this.age + ", tabCompte="
				+ Arrays.toString(this.tabCompte) + "]";
	}
	
}
