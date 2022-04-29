package org.diginamic.fr.jdbc.entites;

public class Compo {
	private Integer id;
	private Integer idArt;
	private Integer idBon;
	private Integer qte;
	
	public Compo(Integer id, Integer idArt, Integer idBon, Integer qte) {
		super();
		this.id = id;
		this.idArt = idArt;
		this.idBon = idBon;
		this.qte = qte;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdArt() {
		return idArt;
	}

	public void setIdArt(Integer idArt) {
		this.idArt = idArt;
	}

	public Integer getIdBon() {
		return idBon;
	}

	public void setIdBon(Integer idBon) {
		this.idBon = idBon;
	}

	public Integer getQte() {
		return qte;
	}

	public void setQte(Integer qte) {
		this.qte = qte;
	}

	
}
