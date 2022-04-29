package org.diginamic.fr.jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.model.Fournisseur;

public class TestSelect {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection connection = TestConnexionJdbc.getConnection();
			ArrayList<Fournisseur> fournisseurs = new ArrayList<>();

			Statement stat = connection.createStatement();
			ResultSet curseur = stat.executeQuery("SELECT * FROM fournisseur");

			while (curseur.next()) {
				Integer id = curseur.getInt("ID");
				String nom = curseur.getString("NOM");

				Fournisseur fournisseur = new Fournisseur(id, nom);
				fournisseurs.add(fournisseur);
				System.out.println(fournisseur);
			}
			curseur.close();
			stat.close();

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
