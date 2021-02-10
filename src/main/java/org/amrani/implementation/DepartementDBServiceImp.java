package org.amrani.implementation;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.amrani.jpa.Departement;


public class DepartementDBServiceImp {
	private EntityManager entityManager;

	public DepartementDBServiceImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}


	public void writeDepartement(Departement departement) {
		entityManager.getTransaction().begin();
		entityManager.persist(departement);
		entityManager.getTransaction().commit();
	}

	
	public void writeManyDepartement(List<Departement> listeDepartement) {
		entityManager.getTransaction().begin();
		for (Departement departement : listeDepartement) {
			entityManager.persist(departement);
		}
		entityManager.getTransaction().commit();
	}

	
	public Departement getDepartementById(int id) {
		return (Departement) entityManager.find(Departement.class, id);
	}

	
	public Departement getDepartementByName(String name) {
		String jpql = "select departement from Departement departement where departement.nom = :name";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, name);
		
		return (Departement) query.getSingleResult();
	}

	
	public int countDepartementByCp(String codePostal) {
		String jpql = "select count(*) from Departement departement where departement.codePostal like '" + codePostal + "%'";
		Query query = entityManager.createQuery(jpql);

		return Integer.parseInt(String.valueOf(query.getSingleResult()));
	}

}
