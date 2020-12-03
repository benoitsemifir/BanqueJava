package banque;

import java.util.HashMap;
import java.util.Map;

import banque.Exceptions.BanqueExceptionCompteMax;

public class Client {

	private String nom;
	private String prenom;
	private int age;
	private int numero;
	private Map<Integer, Compte> tabCompte = new HashMap<Integer, Compte>(); //<--
	
	public Client() {
		this("","",0,0);
	}
	
	public Client(String nom, String prenom, int age, int numero) {
		this(nom, prenom, age, numero, new HashMap<Integer, Compte>());
	}
	
	public Client(String nom, String prenom, int age, int numero, Compte[] comptes) {
		this.nom = nom;
		this.prenom = prenom;
		this.setAge(age);
		this.setNumero(numero);
		
		////////////////////
		for(Compte compte: comptes) {
			if(compte != null) {				
				this.tabCompte.put(compte.getNumero(), compte);
			}
		}
	}
	
	public Client(String nom, String prenom, int age, int numero, Map<Integer, Compte> comptes) {// <---
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
		/*
		 * Version décomposée
		Collection<Compte> cpt = this.tabCompte.values();
		return cpt.toArray(new Compte[5]);
		*/
		return this.tabCompte.values().toArray(new Compte[5]);
		//return tabCompte.toArray(new Compte[5]); //<--
	}

	public void setTabCompte(Compte[] tabCompte) {
		
		Map<Integer, Compte> newMap = new HashMap<>();
		for (Compte compte: tabCompte) {
			newMap.put(compte.getNumero(), compte);
		}
		this.tabCompte = newMap;

		//this.tabCompte = Arrays.asList(tabCompte); //<--
	}

	public void ajouterCompte(Compte compte) throws BanqueExceptionCompteMax {
		/* Array
		for (int i = 0; i < this.tabCompte.length ; i++ ) {
			if(this.tabCompte[i] == null) {
				this.tabCompte[i] = compte;
				return;
			}
		}*/
		/* List
		if(this.tabCompte.size()<= 5) {
			this.tabCompte.add(compte);			
		}else {			
			throw new BanqueExceptionCompteMax("Le client a déja 5 comptes");
		}
		*/
		// Map
		if(this.tabCompte.size() <= 5) {
			this.tabCompte.put(compte.getNumero(), compte);
		}else {
			throw new BanqueExceptionCompteMax("Le client a déja 5 comptes");
		}
	}
	
	public Compte getCompte(int numeroCompte) {
		/*// façon List
		for(Compte compte : this.tabCompte) {
				if(compte != null && compte.getNumero() == numeroCompte) {
					return compte;
				}
		}
		*/
		if(this.tabCompte.containsKey(numeroCompte)) {
			return this.tabCompte.get(numeroCompte);
		}
		System.out.println("Aucun compte avec ce numéro");
		return null;
	}

	@Override
	public String toString() {
		return "Client [numero=" + this.numero + ", nom=" + this.nom + ", prenom=" + this.prenom + ", age=" + this.age + ", tabCompte="
				+ this.tabCompte.toString() + "]";
	}
	
}
