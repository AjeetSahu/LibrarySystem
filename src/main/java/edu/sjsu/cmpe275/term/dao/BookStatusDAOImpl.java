package edu.sjsu.cmpe275.term.dao;

import org.springframework.stereotype.Repository;
import edu.sjsu.cmpe275.term.model.BookStatus;

@Repository
public class BookStatusDAOImpl extends AbstractDao<String, BookStatus>  implements BookStatusDAO{
	@Override
	public BookStatus issueBooks(BookStatus bookStatus) {
		return save(bookStatus);
	}
	
	@Override
	public String returnBooks(String bookStatusId) {
		return deleteById(bookStatusId);
	}
}

