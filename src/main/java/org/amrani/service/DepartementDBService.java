package org.amrani.service;

import java.util.List;

import org.amrani.jpa.Departement;

public interface DepartementDBService {
	
	/**
	 * @param departement
	 */
	void writeDepartement(Departement departement);
	
	/**
	 * @param listeDepartement
	 */
	void writeManyDepartement(List<Departement> listeDepartement);
	
	/**
	 * @param Id
	 * @return
	 */
	Departement getDepartementById(int Id);
	
	/**
	 * @param name
	 * @return
	 */
	Departement getDepartementByName(String name);
	
	/**
	 * @param codePostal
	 * @return
	 */
	int countDepartementByCp(String codePostal);
}
