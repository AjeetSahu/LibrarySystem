package edu.sjsu.cmpe275.term.dao;

import edu.sjsu.cmpe275.term.model.Patron;

public interface PatronDAO {
	
	public Patron saveNewPatron(Patron patron);
	public Patron findPatronById(String id);
	
}
