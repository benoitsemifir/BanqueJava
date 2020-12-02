import banque.*;

public class Run {

	public static void main(String[] args) {
		
		Client client = new Client("Routier", "Benoît", 27, 1);
		Compte livretA = new CompteRemunere(1,20, 0.05);
		Compte compteBloque = new CompteASeuil(2, 50, 20);
			
		System.out.println(client.toString());
		client.ajouterCompte(livretA);
		System.out.println(client.toString());
		client.ajouterCompte(compteBloque);
		System.out.println(client.toString());
		
		client.getCompte(1).ajouter(20);
		client.getCompte(2).ajouter(5);
		System.out.println(client.toString());
		client.getCompte(1).retirer(10);
		client.getCompte(2).retirer(20);
		System.out.println(client.toString());
		
		client.getCompte(1).retirer(4000);
		client.getCompte(2).retirer(4000);
		
		System.out.println(client.toString());
		
		Compte[] comptes = client.getTabCompte();
		
		for (Compte compte : comptes) {
			if(compte instanceof CompteRemunere) {
				CompteRemunere cpt = (CompteRemunere) compte;
				cpt.verserInterets();
			}
		}
				
		System.out.println(client.toString());
	}

}
