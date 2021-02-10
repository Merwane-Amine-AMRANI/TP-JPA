package org.amrani.implementation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.amrani.jpa.Maire;
import org.amrani.service.MaireImporter;

public class MaireImporterImp implements MaireImporter{

	@Override
	public void importMaires(String pathName) {
		String persistenceUnitNameJpa = "tp-jpa-eclipselink-create";
		EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory(persistenceUnitNameJpa);
		EntityManager entityManager = entityManagerFactory.createEntityManager();

		entityManager.getTransaction().begin();

		Path path = Path.of(pathName);

		try (Stream<String> lines = Files.lines(path);) {
			
			List<String> listeLine = lines.skip(1).collect(Collectors.toList());
			
			List<Maire> collect = listeLine.stream().map(ligneToMaire).collect(Collectors.toList());
			
			for (Maire maire : collect) {
				entityManager.persist(maire);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		entityManager.getTransaction().commit();
	}

	Function<String, Maire> ligneToMaire = str -> {
		String[] split = str.split(";");
		return new Maire(split[0], Integer.parseInt(split[1]));
	};

}
