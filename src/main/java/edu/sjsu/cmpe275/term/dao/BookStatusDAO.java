package edu.sjsu.cmpe275.term.dao;

import edu.sjsu.cmpe275.term.model.BookStatus;

public interface BookStatusDAO {

	public BookStatus issueBooks(BookStatus bookStatus);
	
}
