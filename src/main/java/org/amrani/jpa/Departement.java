package org.amrani.jpa;

import java.io.Serializable;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@SuppressWarnings("serial")
@Entity (name = "Departement")
@Access(AccessType.FIELD)
public class Departement implements Serializable{

	@Id @GeneratedValue(strategy = GenerationType.AUTO)
	private long id;

	@Column(length = 40)
	private String nom;
	
	@Column(length = 40)
	private String codePostal;
	
	public Departement() {
	}

	public Departement(String nom, String codePostal) {
		this.nom = nom;
		this.codePostal = codePostal;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getCodePostal() {
		return codePostal;
	}

	public void setCodePostal(String codePostal) {
		this.codePostal = codePostal;
	}

	@Override
	public String toString() {
		return "Departement [id=" + id + ", nom=" + nom + ", codePostal=" + codePostal + "]";
	}
}