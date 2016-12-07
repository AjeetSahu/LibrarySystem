package edu.sjsu.cmpe275.term.service;

import java.util.List;
import edu.sjsu.cmpe275.term.model.BookStatus;

public interface BookStatusService {
	public void issueBooks(BookStatus bookStatus);
	public String returnBooks(String bookStatusId);
	public List<BookStatus> getListOfIssuedBooks(String patronId);
}
