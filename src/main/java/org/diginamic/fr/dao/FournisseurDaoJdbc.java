package org.diginamic.fr.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.jdbc.entites.Fournisseur;

public class FournisseurDaoJdbc implements FournisseurDao {

	@Override
	public ArrayList<Fournisseur> extraire() {

		ArrayList<Fournisseur> fournisseurs = new ArrayList<>();
		try {
			Connection connection = TestConnexionJdbc.getConnection();

			Statement stat = connection.createStatement();
			ResultSet curseur = stat.executeQuery("SELECT * FROM fournisseur");

			while (curseur.next()) {
				Integer id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");

				Fournisseur fournisseur = new Fournisseur(id, nom);
				fournisseurs.add(fournisseur);
			}
			curseur.close();
			stat.close();

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return fournisseurs;
	}

	@Override
	public void insert(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
	}

	@Override
	public int update(String ancienNom, String nouveauNom) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public boolean delete(Fournisseur fournisseur) {
		// TODO Auto-generated method stub
		return false;
	}

}
