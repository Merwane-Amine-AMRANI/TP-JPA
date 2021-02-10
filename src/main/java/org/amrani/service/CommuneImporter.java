package org.amrani.service;

import java.sql.SQLException;

public interface CommuneImporter {

	/**
	 * @param pathName
	 * @throws SQLException 
	 */
	void importCommunes(String pathName) throws SQLException;

}
