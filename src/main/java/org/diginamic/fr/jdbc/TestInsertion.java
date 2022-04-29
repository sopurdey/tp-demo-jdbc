package org.diginamic.fr.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import org.diginamic.fr.TestConnexionJdbc;

public class TestInsertion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection connection = TestConnexionJdbc.getConnection();
			Statement stat = connection.createStatement();
			int nb = stat.executeUpdate("INSERT INTO fournisseur (ID, NOM) VALUES (4, 'La Maison de la Peinture')");
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

}
