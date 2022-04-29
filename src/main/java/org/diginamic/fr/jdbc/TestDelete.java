package org.diginamic.fr.jdbc;

import java.sql.Connection;
import java.sql.Statement;

import org.diginamic.fr.TestConnexionJdbc;

public class TestDelete {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Connection connection = TestConnexionJdbc.getConnection();
			Statement stat = connection.createStatement();
			int nb = stat.executeUpdate("DELETE FROM fournisseur WHERE ID=4");
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

}
