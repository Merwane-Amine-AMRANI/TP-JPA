package org.amrani.service;

import java.util.List;

import org.amrani.jpa.Commune;

public interface CommuneDBService {

	/**
	 * @param commmune
	 * @return 
	 */
	void writeCommune(Commune commmune);
	
	/**
	 * @param commmune
	 */
	void writeManyCommune(List<Commune> commmune);

	/**
	 * @param id
	 * @return
	 */
	Commune getCommuneById(int id);

	/**
	 * @param name
	 * @return
	 */
	Commune getCommuneByName(String name);

	/**
	 * @param codePostal
	 * @return
	 */
	int countCommuneByCP(String codePostal);

}
