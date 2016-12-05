package edu.sjsu.cmpe275.term.service;

import edu.sjsu.cmpe275.term.model.Librarian;

/**
 * @author Ajeet
 *
 */
public interface LibrarianService {
	
	public Librarian saveNewLibrarian(Librarian librarian);
	/**
	 * @author Pratik
	 *
	 */
	public Librarian findLibrarianById(String id);
	public Librarian findLibrarianByUniversityId(String id);

}
