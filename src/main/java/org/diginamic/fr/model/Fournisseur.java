package org.diginamic.fr.model;

/**
 * Description de la Table Fournisseur par une Classe Que nous utiliserons de
 * fa�on manuelle
 * 
 * @author AP
 *
 */
public class Fournisseur {
	private Integer id;
	private String nom;

	public Fournisseur(Integer id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
	}

	@Override
	public String toString() {
		return "Fournisseur [id=" + id + ", nom=" + nom + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

}
