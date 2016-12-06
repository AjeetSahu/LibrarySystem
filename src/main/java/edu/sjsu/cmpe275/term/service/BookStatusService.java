package edu.sjsu.cmpe275.term.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.term.dao.BookDAO;
import edu.sjsu.cmpe275.term.dao.BookStatusDAO;
import edu.sjsu.cmpe275.term.model.BookStatus;

public interface BookStatusService {
	public void issueBooks(BookStatus bookStatus);
	

}
