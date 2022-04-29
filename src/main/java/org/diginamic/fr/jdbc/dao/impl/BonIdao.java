package org.diginamic.fr.jdbc.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.diginamic.fr.jdbc.dao.IDao;
import org.diginamic.fr.jdbc.entites.Bon;

public class BonIdao implements IDao<Bon> {

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
	public List<Bon> extraire() {
		List<Bon> listeBons = new ArrayList<Bon>();
		String sql = "SELECT (ID, NUMERO, DATE_CMDE, DELAI, ID_FOU) FROM bon";

		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			// import java.sql
			ResultSet curseur = stat.executeQuery();
			while (curseur.next()) {
				Bon bo = new Bon(curseur.getInt("ID"), curseur.getInt("NUMERO"),
						curseur.getDate("DATE_CMDE"), curseur.getInt("DELAI"), curseur.getInt("ID_FOU"));
				listeBons.add(bo);
			}
			curseur.close();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return listeBons;
	}

	@Override
	public void insert(Bon bon) {
		String sql = "INSERT INTO bon (ID, NUMERO, DATE_CMDE, DELAI, ID_FOU) VALUES (?, ?, ?, ?, ?);";
		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setInt(1, bon.getId());
			stat.setInt(2, bon.getNumero());
			stat.setDate(3, bon.getDateCmde());
			stat.setInt(4, bon.getDelai());
			stat.setInt(5, bon.getIdFou());
			stat.executeUpdate();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}

	}

	@Override
	public int update(Bon ancienB, Bon nouveauB) {
		String sql = "UPDATE bon SET NUMERO='?', DATE_CMDE='?', DELAI='?', ID_FOU='?' WHERE ID ='?'";
		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setInt(1, nouveauB.getNumero());
			stat.setDate(2, nouveauB.getDateCmde());
			stat.setInt(3, nouveauB.getDelai());
			stat.setInt(4, nouveauB.getIdFou());
			stat.setInt(5, ancienB.getId());
			stat.executeUpdate();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return ancienB.getId();
	}

	@Override
	public boolean delete(Bon bon) {
		String sql = "DELETE FROM bon WHERE ID='?';";
		try {
			PreparedStatement stat = connexion.prepareStatement(sql);
			stat.setInt(1, bon.getId());
			stat.executeUpdate();
			stat.close();
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
		return false;
	}

}
