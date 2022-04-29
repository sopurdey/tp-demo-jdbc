package org.diginamic.fr.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.TestConnexionJdbc;
import org.diginamic.fr.jdbc.dao.IDao;
import org.diginamic.fr.jdbc.entites.Compo;

public class CompoIdao implements IDao<Compo> {

	private Connection connexion = null;

	public CompoIdao() throws Exception {
		connexion = TestConnexionJdbc.getConnection();
	}

	/**
	 * fermer la connexion à la bdd
	 * 
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
	public List<Compo> extraire() {

		List<Compo> listeCompos = new ArrayList<Compo>();
		String sql = "SELECT ID, ID_ART, ID_BON, QTE FROM compo";

		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			// import java.sql
			ResultSet curseur = stat.executeQuery();
			while (curseur.next()) {
				/**
				 * Je veux récupérer la colonne ID et la colonne Nom de ma table la stocker dans
				 * un objet de type Compo et la mettre dans notre Liste
				 */
				Compo co = new Compo(curseur.getInt("ID"), curseur.getInt("ID_ART"), curseur.getInt("ID_BON"),
						curseur.getInt("QTE"));
				listeCompos.add(co);
			}
			/**
			 * Je ferme dans l'ordre mon ResulSet puis mon Statement
			 */
			curseur.close();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return listeCompos;
	}

	@Override
	public void insert(Compo co) {
		String sql = "INSERT INTO compo (ID, ID_ART, ID_BON, QTE) VALUES (?, ?, ?, ?);";
		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setInt(1, co.getId());
			stat.setInt(2, co.getIdArt());
			stat.setInt(3, co.getIdBon());
			stat.setInt(4, co.getQte());
			stat.executeUpdate();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	@Override
	public int update(Compo ancienCo, Compo nouveauCo) {
		String sql = "UPDATE compo SET ID_ART=?, ID_BON=?, QTE=? WHERE ID =?";
		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setInt(1, nouveauCo.getIdArt());
			stat.setInt(2, nouveauCo.getIdBon());
			stat.setInt(3, nouveauCo.getQte());
			stat.setInt(4, ancienCo.getId());
			stat.executeUpdate();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return ancienCo.getId();
	}

	@Override
	public boolean delete(Compo co) {
		String sql = "DELETE FROM compo WHERE ID=?;";
		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setInt(1, co.getId());
			stat.executeUpdate();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return false;
	}

}
