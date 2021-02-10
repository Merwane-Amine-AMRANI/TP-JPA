package org.amrani.implementation;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.amrani.jpa.Departement;
import org.amrani.service.DepartementImporter;

public class DepartementImporterImp implements DepartementImporter {

	@Override
	public void impoterDepartement(String pathName) {
		String persistenceUnitNameJpa = "tp-jpa-eclipselink-create";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitNameJpa);
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		Path path = Path.of(pathName);

		try (Stream<String> lines = Files.lines(path, Charset.forName("Cp1252"));) {
			
			List<String> listeLine = lines.skip(1).collect(Collectors.toList());
			
			List<Departement> collect = listeLine.stream().map(ligneToDepartement).collect(Collectors.toList());
			
			for (Departement departement : collect) {
				entityManager.persist(departement);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		entityManager.getTransaction().commit();
	}

	Function<String, Departement> ligneToDepartement = str -> {
		String[] split = str.split(";");
		return new Departement(split[0], split[1]);
	};

}