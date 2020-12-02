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
		
		//Foreach: pour chaques comptes présent dans comptes
		for (Compte compte : comptes) {
			// si compte est de la famille de CompteRemunere
			if(compte instanceof CompteRemunere) {
				// DownCast de Compte vers CompteRemunere
				CompteRemunere cpt = (CompteRemunere) compte;
				// appel de la methode verserInteret propre à CompteRemunere
				cpt.verserInterets();
			}
		}
				
		System.out.println(client.toString());
	}

}
