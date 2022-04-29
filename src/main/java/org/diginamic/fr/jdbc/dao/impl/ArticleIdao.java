package org.diginamic.fr.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.jdbc.dao.IDao;
import org.diginamic.fr.jdbc.entites.Article;

public class ArticleIdao implements IDao<Article> {

	private Connection connexion = null;

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
	public List<Article> extraire() {
		List<Article> listeArticles = new ArrayList<Article>();
		String sql = "SELECT (ID, REF, DESIGNATION, PRIX, ID_FOU) FROM article";

		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			// import java.sql
			ResultSet curseur = stat.executeQuery();
			while (curseur.next()) {
				Article ao = new Article(curseur.getInt("ID"), curseur.getString("REF"),
						curseur.getString("DESIGNATION"), curseur.getDouble("PRIX"), curseur.getInt("ID_FOU"));
				listeArticles.add(ao);
			}
			curseur.close();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return listeArticles;
	}

	@Override
	public void insert(Article art) {
		String sql = "INERT INTO article (ID, REF, DESIGNATION, PRIX, ID_FOU) VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setInt(1, art.getId());
			stat.setString(2, art.getRef());
			stat.setString(3, art.getDesignation());
			stat.setDouble(4, art.getPrix());
			stat.setInt(5, art.getIdFou());
			stat.executeUpdate();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

	}

	@Override
	public int update(Article ancienA, Article nouveauA) {
		String sql = "UPDATE article SET REF='?', DESIGNATION='?', PRIX='?', ID_FOU='?' WHERE ID ='?'";
		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setString(1, nouveauA.getRef());
			stat.setString(2, nouveauA.getDesignation());
			stat.setDouble(3, nouveauA.getPrix());
			stat.setInt(4, nouveauA.getIdFou());
			stat.setInt(5, ancienA.getId());
			stat.executeUpdate();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return ancienA.getId();
	}

	@Override
	public boolean delete(Article art) {
		String sql = "DELETE FROM article WHERE ID='?';";
		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setInt(1, art.getId());
			stat.executeUpdate();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return false;
	}

}
