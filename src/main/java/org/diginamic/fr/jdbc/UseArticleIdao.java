package org.diginamic.fr.jdbc;

import org.diginamic.fr.jdbc.dao.IDao;
import org.diginamic.fr.jdbc.dao.impl.ArticleIdao;
import org.diginamic.fr.jdbc.entites.Article;

public class UseArticleIdao {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		/**
		 * Utiliser la classe ArticleIdao pour afficher la liste des Articles
		 */
		try {
			ArticleIdao arti = new ArticleIdao();
			getAffiche(arti);
		} catch (Exception ex) {
			System.err.println(ex.getMessage());
		}
	}

	/**
	 * methode qui gére un objet de type Idao<Article>
	 */
	public static void getAffiche(IDao<Article> o) {
		o.extraire().forEach(art -> System.out
				.println(art.getRef() + " " + art.getDesignation() + " " + art.getPrix() + "€ "));
	}

}
