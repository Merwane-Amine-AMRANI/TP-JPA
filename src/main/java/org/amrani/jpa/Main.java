package org.amrani.jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.amrani.implementation.CommuneDBServiceImp;
import org.amrani.implementation.DepartementImporterImp;
import org.amrani.service.CommuneDBService;
import org.amrani.service.DepartementImporter;

public class Main {

	public static void main(String[] args) {
		
		String persistenceUnitNameJpa = "tp-jpa-hibernate-select";
		String persistenceUnitNameJdbc = "tp-jdbc-hibernate-select";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitNameJpa);

		EntityManagerFactory entityManagerFactory1 = Persistence.createEntityManagerFactory(persistenceUnitNameJdbc);

		EntityManager entityManager = entityManagerFactory.createEntityManager();
		EntityManager entityManager1 = entityManagerFactory1.createEntityManager();

		entityManager1.getTransaction().begin();
		entityManager.getTransaction().begin();
		int i = 1;
		while(entityManager1.find(Commune.class, i) != null) {
			entityManager.persist((Commune) entityManager1.find(Commune.class, i));
			i++;
		};
		
		entityManager1.getTransaction().commit();
		entityManager.getTransaction().commit();
		
		entityManager.getTransaction().begin();
		CommuneDBService communeService = new CommuneDBServiceImp(entityManager);
		
		System.out.println(communeService.getCommuneById(1));
		System.out.println(communeService.getCommuneByName("VOIRES"));
		System.out.println(communeService.countCommuneByCP("33"));
		
		entityManager.getTransaction().commit();
		
		DepartementImporter departementImporter = new DepartementImporterImp();
		departementImporter.impoterDepartement("files/departements.csv");
		double b = Math.sqrt(4);
		System.out.println(b == (int) b);
	}
}
