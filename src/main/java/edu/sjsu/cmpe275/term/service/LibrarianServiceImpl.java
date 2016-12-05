/**
 * 
 */
package edu.sjsu.cmpe275.term.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.sjsu.cmpe275.term.dao.LibrarianDAO;
import edu.sjsu.cmpe275.term.model.Librarian;

/**
 * @author Ajeet
 *
 */
@Service
public class LibrarianServiceImpl implements LibrarianService{
	
	@Autowired
	private LibrarianDAO librarianDAO;
	
	public void setLibrarianDAO(LibrarianDAO librarianDAO){
		this.librarianDAO = librarianDAO;
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.term.service.LibrarianService#saveNewLibrarian(edu.sjsu.cmpe275.term.model.Librarian)
	 */
	@Override
	public Librarian saveNewLibrarian(Librarian librarian) {
		return librarianDAO.saveNewLibrarian(librarian);
	}
	/**
	 * @author Pratik
	 *
	 */
	@Override
	public Librarian findLibrarianById(String id) {
		return librarianDAO.findLibrarianById(id);
	}

	@Override
	public Librarian findLibrarianByUniversityId(String id) {
		return librarianDAO.findLibrarianById(id);
	}

	@Override
	public void updateLibrarian(Librarian librarian) {
		librarianDAO.updateLibrarian(librarian);
	}

	@Override
	public Librarian findLibrarianByEmailId(String id) {
		return librarianDAO.findLibrarianByEmailId(id);
	}

}
