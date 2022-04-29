package org.diginamic.fr.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.jdbc.dao.IDao;
import org.diginamic.fr.jdbc.entites.Fournisseur;

public class FournisseurIdao implements IDao<Fournisseur> {

	private Connection connexion = null;

	public FournisseurIdao() throws Exception {
		connexion = TestConnexionJdbc.getConnection();
	}

	/**
	 * fermer la connexion à la bdd
	 * @throws Exception
	 */
	public void close() throws Exception {
		if (connexion != null && connexion.isClosed() == false) {
			connexion.close();
		}
	}

	/**
	 * Méthode déstructeur + ferme la connexion bdd
	 */
	@Override
	protected void finalize() throws Throwable {
		close();
	}

	@Override
	public List<Fournisseur> extraire() {

		List<Fournisseur> listeFournisseurs = new ArrayList<Fournisseur>();
		String sql = "SELECT ID,NOM FROM fournisseur";
		
		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			// import java.sql
			ResultSet curseur = stat.executeQuery();
			while (curseur.next()) {
				/**
				 * Je veux récupérer la colonne ID et la colonne Nom de ma table la stocker dans
				 * un objet de type Fournisseur et la mettre dans notre Liste
				 */
				Fournisseur fo = new Fournisseur(curseur.getInt("ID"), curseur.getString("NOM"));
				listeFournisseurs.add(fo);
			}
			/**
			 * Je ferme dans l'ordre mon ResulSet puis mon Statement
			 */
			curseur.close();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return 	listeFournisseurs;
	}

	@Override
	public void insert(Fournisseur fo) {
		String sql = "INSERT INTO fournisseur (ID, NOM) VALUES (?, ?);";
		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setInt(1, fo.getId());
			stat.setString(2, fo.getNom());
			stat.executeUpdate();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	@Override
	public int update(Fournisseur ancienFo, Fournisseur nouveauFo) {
		String sql = "UPDATE fournisseur SET NOM=? WHERE ID=?";
		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setString(1, nouveauFo.getNom());
			stat.setInt(2, ancienFo.getId());
			stat.executeUpdate();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return ancienFo.getId();
	}

	@Override
	public boolean delete(Fournisseur fo) {
		String sql = "DELETE FROM fournisseur WHERE ID=?;";
		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setInt(1, fo.getId());
			stat.executeUpdate();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return false;
	}

}
