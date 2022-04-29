package org.diginamic.fr;

import java.util.List;

import org.diginamic.fr.jdbc.dao.FournisseurDao;
import org.diginamic.fr.model.Fournisseur;

public class App02 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Fournisseur> maliste = FournisseurDao.getAll();
		
		for(Fournisseur fo: maliste) {
			System.out.println("id : " + fo.getId() + " Nom : " + fo.getNom());
		}
	}

}
