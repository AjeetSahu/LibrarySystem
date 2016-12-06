package edu.sjsu.cmpe275.term.dao;

import org.springframework.stereotype.Repository;
import edu.sjsu.cmpe275.term.dao.AbstractDao;
import edu.sjsu.cmpe275.term.model.Librarian;

/**
 * @author Ajeet
 *
 */

@Repository
public class LibrarianDAOImpl extends AbstractDao<String, Librarian> implements LibrarianDAO{

	@Override
	public Librarian saveNewLibrarian(Librarian librarian) {
		return save(librarian);
	}
	/**
	 * @author Pratik
	 *
	 */	
	@Override
	public Librarian findLibrarianByUniversityId(String id) {
		return findByIdOfTypeString(id);
	}
	
	@Override
	public void updateLibrarian(Librarian librarian) {
		update(librarian);
	}
	@Override
	public Librarian findLibrarianByEmailId(String id) {
		return findByIdOfTypeString(id);
	}
	

}
