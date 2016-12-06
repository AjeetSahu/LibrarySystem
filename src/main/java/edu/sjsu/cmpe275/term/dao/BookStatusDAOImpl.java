package edu.sjsu.cmpe275.term.dao;

import edu.sjsu.cmpe275.term.model.BookStatus;

public class BookStatusDAOImpl extends AbstractDao<String, BookStatus>  implements BookStatusDAO {

	@Override
	public String returnBooks(String bookStatusId) {
		return deleteById(bookStatusId);
	}
	
}
