package edu.sjsu.cmpe275.term.dao;

import java.io.Serializable;

import edu.sjsu.cmpe275.term.model.Book;
import edu.sjsu.cmpe275.term.model.Patron;

public class PatronDAOImpl extends AbstractDao<String, Patron> implements PatronDAO{

	@Override
	public Patron saveNewPatron(Patron patron) {
		return save(patron);
	}






}
