package edu.sjsu.cmpe275.term.service;

import org.springframework.beans.factory.annotation.Autowired;
import edu.sjsu.cmpe275.term.dao.BookStatusDAO;
import edu.sjsu.cmpe275.term.model.BookStatus;

public class BookStatusServiceImpl implements BookStatusService {

	@Autowired
	private BookStatusDAO bookStatusDAO;

	public void setBookStatusDAO(BookStatusDAO bookStatusDAO) {
		this.bookStatusDAO = bookStatusDAO;
	}

	@Override
	public void issueBooks(BookStatus bookStatus) {
		bookStatusDAO.issueBooks(bookStatus);
	}
	
	@Override
	public String returnBooks(String bookStatusId) {
		return bookStatusDAO.returnBooks(bookStatusId);
	}
}
