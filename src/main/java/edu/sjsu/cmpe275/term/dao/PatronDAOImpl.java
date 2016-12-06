package edu.sjsu.cmpe275.term.dao;

import edu.sjsu.cmpe275.term.model.Patron;

public class PatronDAOImpl extends AbstractDao<String, Patron> implements PatronDAO{

	@Override
	public Patron saveNewPatron(Patron patron) {
		return save(patron);
	}
	
	@Override
	public Patron findPatronByUniversityId(String id) {
		return findByIdOfTypeString(id);
	}
	
	@Override
	public void updatePatron(Patron patron) {
		update(patron);		
	}
	
	@Override
	public Patron findPatronByEmailId(String id) {
		return findByIdOfTypeString(id);
	}

}
