/**
 * 
 */
package edu.sjsu.cmpe275.term.dao;

import edu.sjsu.cmpe275.term.model.Librarian;
import edu.sjsu.cmpe275.term.model.Patron;

/**
 * @author Ajeet
 *
 */
public interface LibrarianDAO {
	
	public Librarian saveNewLibrarian(Librarian librarian);
	/**
	 * @author Pratik
	 *
	 */
	public Librarian findLibrarianById(String id);

}
