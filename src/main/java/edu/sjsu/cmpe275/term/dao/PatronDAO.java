package edu.sjsu.cmpe275.term.dao;

import edu.sjsu.cmpe275.term.model.Patron;

public interface PatronDAO {
	
	public Patron saveNewPatron(Patron patron);
	/**
	 * @author Pratik
	 * @param id
	 * @return
	 */
	public Patron findPatronById(String id);
	/**
	 * @author Pratik
	 * @param id
	 * @return
	 */
	public Patron findPatronByUniversityId(String id);
	/**
	 * @author Pratik
	 * @param patron
	 */
	public void updatePatron(Patron patron);
}
