package org.diginamic.fr.jdbc.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.model.Fournisseur;

/**
 * Cette classe va me permettre de lire en JDBC la Table fournissuer et aussi
 * d'avoir les méthodes CRUD et d'obtenir des objets de type Fournisseur
 * 
 * @author Formation
 *
 */
public class FournisseurDao {

	/**
	 * Retourne la liste des Fournisseurs de ma base de données
	 * 
	 * @return
	 */
	public static List<Fournisseur> getAll() {
		Connection connection = null;
		List<Fournisseur> listeDesFournisseurs = new ArrayList<>();

		try {
			connection = TestConnexionJdbc.getConnection();

			Statement stat = connection.createStatement();
			ResultSet curseur = stat.executeQuery("SELECT * FROM fournisseur");
			while (curseur.next()) {
				/**
				 * Je veux récupérer la colonne ID et la colonne Nom les stocker dans un objet
				 * de type Fournisseur la mettre dans la liste
				 */
				Fournisseur fo = new Fournisseur(curseur.getInt("ID"), curseur.getString("NOM"));
				listeDesFournisseurs.add(fo);
			}
			// fermer dans l'ordre inverse de l'ouverture
			curseur.close();
			stat.close();

		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		} finally {
			try {
				if (connection != null)
					connection.close();
			} catch (Exception ex) {
				System.err.println(ex.getMessage());
			}
		}
		return listeDesFournisseurs;
	}
}
