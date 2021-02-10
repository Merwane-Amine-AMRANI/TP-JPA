package org.amrani.implementation;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.amrani.jpa.Commune;
import org.amrani.service.CommuneDBService;

public class CommuneDBServiceImp implements CommuneDBService{

	private EntityManager entityManager;

	public CommuneDBServiceImp(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	@Override
	public void writeCommune(Commune commune) {
		entityManager.getTransaction().begin();
		entityManager.persist(commune);
		entityManager.getTransaction().commit();
	}

	@Override
	public void writeManyCommune(List<Commune> commmunes) {
		entityManager.getTransaction().begin();
		for (Commune commune : commmunes) {
			entityManager.persist(commune);
		}
		entityManager.getTransaction().commit();
	}
	
	@Override
	public Commune getCommuneById(int id) {
		return (Commune) entityManager.find(Commune.class, id);
	}

	@Override
	public Commune getCommuneByName(String name) {
		String jpql = "select commune from Commune commune where commune.nomCommune = :name";
		Query query = entityManager.createQuery(jpql);
		query.setParameter(1, name);
		
		return (Commune) query.getSingleResult();
	}

	@Override
	public int countCommuneByCP(String codePostal) {
		String jpql = "select count(*) from Commune commune where commune.codePostal like '" + codePostal + "%'";
		Query query = entityManager.createQuery(jpql);
//		query.setParameter("code", codePostal);
		
		return Integer.parseInt(String.valueOf(query.getSingleResult()));
	}

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager entityManager) {
		this.entityManager = entityManager;
	}

	
}

