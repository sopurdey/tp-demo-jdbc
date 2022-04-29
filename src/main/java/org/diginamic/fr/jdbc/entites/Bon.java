package org.diginamic.fr.jdbc.entites;

import java.sql.Date;

public class Bon {
	private Integer id;
	private Integer numero;
	private Date dateCmde;
	private Integer delai;
	private Integer idFou;

	public Bon(Integer id, Integer numero, Date dateCmde, Integer delai, Integer idFou) {
		super();
		this.id = id;
		this.numero = numero;
		this.dateCmde = dateCmde;
		this.delai = delai;
		this.idFou = idFou;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Date getDateCmde() {
		return dateCmde;
	}

	public void setDateCmde(Date dateCmde) {
		this.dateCmde = dateCmde;
	}

	public Integer getDelai() {
		return delai;
	}

	public void setDelai(Integer delai) {
		this.delai = delai;
	}

	public Integer getIdFou() {
		return idFou;
	}

	public void setIdFou(Integer idFou) {
		this.idFou = idFou;
	}

}
