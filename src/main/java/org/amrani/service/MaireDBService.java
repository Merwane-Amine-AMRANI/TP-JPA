package org.amrani.service;

import java.util.List;

import org.amrani.jpa.Maire;

public interface MaireDBService {
	
	void writeMaire(Maire maire);

	/**
	 * @param maire
	 */
	void writeManyMaire(List<Maire> maire);

	/**
	 * @param id
	 * @return
	 */
	Maire getMaireById(int id);

	/**
	 * @param name
	 * @return
	 */
	Maire getMaireByName(String name);

	/**
	 * @param codePostal
	 * @return
	 */
	int countMaireByCP(String codePostal);
}
