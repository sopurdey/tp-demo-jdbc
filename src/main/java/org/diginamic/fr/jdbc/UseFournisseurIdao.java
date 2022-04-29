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
			//addFournisseur(foi);
			//updateFournisseur(foi);
			//deleteFournisseur(foi);
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
	
	public static void addFournisseur(IDao<Fournisseur> o) {
		Fournisseur fTest = new Fournisseur(4, "Test insert Fournisseur");
		try {			
			o.insert(fTest);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		getAffiche(o);
	}
	
	public static void updateFournisseur(IDao<Fournisseur> o) {
		Fournisseur oldF = new Fournisseur(4, "Test insert Fournisseur");
		Fournisseur newF = new Fournisseur(4, "Test update Fournisseur");
		try {
			o.update(oldF, newF);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		getAffiche(o); 
	}
	
	public static void deleteFournisseur(IDao<Fournisseur> o) {
		Fournisseur testDel = new Fournisseur(4, "Test update Fournisseur");
		try {
			o.delete(testDel);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
