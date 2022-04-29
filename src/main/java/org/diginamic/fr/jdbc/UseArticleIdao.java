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
			//addArticle(arti);
			//updateArticle(arti);
			//deleteArticle(arti);
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


	public static void addArticle(IDao<Article> o) {
		Article artTest = new Article(11, "F03", "Boulon laiton 6 x 12 mm (sachet de 8)", 3.20, 3);
		try {			
			o.insert(artTest);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		getAffiche(o);
	}
	
	public static void updateArticle(IDao<Article> o) {
		Article oldA = new Article(11, "F03", "Boulon laiton 6 x 12 mm (sachet de 8)", 3.20, 3);
		Article newA = new Article(11, "F03", "Boulon laiton 6 x 12 mm (sachet de 10)", 3.85, 3);
		try {
			o.update(oldA, newA);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
		getAffiche(o); 
	}
	
	public static void deleteArticle(IDao<Article> o) {
		Article testDel = new Article(11, "F03", "Boulon laiton 6 x 12 mm (sachet de 10)", 3.85, 3);
		try {
			o.delete(testDel);
		} catch(Exception ex) {
			System.err.println(ex.getMessage());
		}
	}
}
