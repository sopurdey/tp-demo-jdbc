package org.diginamic.fr.jdbc;

import org.diginamic.fr.jdbc.dao.IDao;
import org.diginamic.fr.jdbc.dao.impl.FournisseurIdao;
import org.diginamic.fr.jdbc.entites.Fournisseur;

public class UseFournisseurIdao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Utiliser la classe FournisseurIdao pour afficher la liste des Fournisseurs
		 */
		try {
			FournisseurIdao foi = new FournisseurIdao();
			getAffiche(foi);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	/**
	 * methode qui gére un objet de type Idao<Fournisseur>
	 */
	public static void getAffiche(IDao<Fournisseur> o) {
		o.extraire().forEach(fo -> System.out.println(fo.getNom()));
	}

}
