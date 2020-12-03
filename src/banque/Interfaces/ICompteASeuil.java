package banque.Interfaces;

import banque.Exceptions.BanqueException;

public interface ICompteASeuil {
	void retirer(double valeur) throws BanqueException;
	double getSeuil();
	void setSeuil(double seuil);
}
