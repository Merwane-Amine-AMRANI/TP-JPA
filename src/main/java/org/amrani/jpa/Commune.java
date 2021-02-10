package org.amrani.jpa;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity (name = "Commune")
@Access(AccessType.FIELD)
public class Commune implements Serializable {

	@Id
	private int id;

	@Column(length = 40)
	private String codeINSEE;
	
	@Column(length = 40)
	private String nomCommune;
	
	@Column(length = 40)
	private int codePostal;
	
	@Column(length = 40)
	private String libelleAcheminement;

	public Commune(String codeINSEE, String nomCommune, int codePostal, String libelleAcheminement) {
		this.codeINSEE = codeINSEE;
		this.nomCommune = nomCommune;
		this.codePostal = codePostal;
		this.libelleAcheminement = libelleAcheminement;
	}

	public Commune() {
	}

	public String getCodeINSEE() {
		return codeINSEE;
	}

	public void setCodeINSEE(String codeINSEE) {
		this.codeINSEE = codeINSEE;
	}

	public String getNomCommune() {
		return nomCommune;
	}

	public void setNomCommune(String nomCommune) {
		this.nomCommune = nomCommune;
	}

	public int getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(int codePostal) {
		this.codePostal = codePostal;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getLibelleAcheminement() {
		return libelleAcheminement;
	}

	public void setLibelleAchivement(String libelleAcheminement) {
		this.libelleAcheminement = libelleAcheminement;
	}

	@Override
	public String toString() {
		return "Commune [codeINSEE=" + codeINSEE + ", nomCommune=" + nomCommune + ", codePostal=" + codePostal
				+ ", libelleAcheminement=" + libelleAcheminement + "]";
	}
}
