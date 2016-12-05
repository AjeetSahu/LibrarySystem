package edu.sjsu.cmpe275.term.dao;

import edu.sjsu.cmpe275.term.model.Librarian;

/**
 * @author Ajeet
 *
 */
public interface LibrarianDAO {
	
	public Librarian saveNewLibrarian(Librarian librarian);
	/**
	 * @author Pratik
	 * @param id
	 * @return
	 */
	public Librarian findLibrarianById(String id);
	/**
	 * @author Pratik
	 * @param id
	 * @return
	 */
	public Librarian findLibrarianByUniversityId(String id);
	/**
	 * @author Pratik
	 * @param librarian
	 */
	public void updateLibrarian(Librarian librarian);
}
