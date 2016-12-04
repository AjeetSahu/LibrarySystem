package edu.sjsu.cmpe275.term.service;

import edu.sjsu.cmpe275.term.model.Patron;

public interface PatronService {
	public Patron saveNewPatron(Patron patron);
	/**
	 * @author Pratik
	 *
	 */
	public Patron findPatronById(String id);
}
