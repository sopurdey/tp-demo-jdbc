package org.diginamic.fr.dao;

import java.util.List;

import org.diginamic.fr.jdbc.entites.Fournisseur;

public interface FournisseurDao {
	List<Fournisseur> extraire();
	void insert(Fournisseur fournisseur);
	int update(String ancienNom, String nouveauNom);
	boolean delete(Fournisseur fournisseur);
}
