package edu.sjsu.cmpe275.term.dao;

import edu.sjsu.cmpe275.term.model.BookStatus;
import edu.sjsu.cmpe275.term.model.Librarian;

public class BookStatusDAOImpl extends AbstractDao<Integer, BookStatus>  implements BookStatusDAO{

	public BookStatus issueBooks(BookStatus bookStatus) {
		// TODO Auto-generated method stub
		return save(bookStatus);
	}
}




