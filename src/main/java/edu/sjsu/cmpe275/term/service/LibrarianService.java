package edu.sjsu.cmpe275.term.service;

import edu.sjsu.cmpe275.term.model.Librarian;

/**
 * @author Ajeet
 *
 */
public interface LibrarianService {
	
	/**
	 * 
	 * @param librarian
	 * @return
	 */
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
