package edu.sjsu.cmpe275.term.service;

import org.springframework.beans.factory.annotation.Autowired;
import edu.sjsu.cmpe275.term.dao.BookStatusDAO;

public class BookStatusServiceImpl implements BookStatusService {

	@Autowired
	BookStatusDAO bookStatusDAO;

	@Override
	public String returnBooks(String bookStatusId) {
		return bookStatusDAO.returnBooks(bookStatusId);
	}

}
