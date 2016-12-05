package edu.sjsu.cmpe275.term.service;

import edu.sjsu.cmpe275.term.model.Patron;

public interface PatronService {
	/**
	 * 
	 * @param patron
	 * @return
	 */
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
	 * @param id
	 * @return
	 */
	public Patron findPatronByEmailId(String id);
	/**
	 * @author Pratik
	 * @param patron
	 */
	public void updatePatron(Patron patron);
}