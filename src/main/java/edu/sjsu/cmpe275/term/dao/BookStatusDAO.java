package edu.sjsu.cmpe275.term.dao;

import java.util.List;
import edu.sjsu.cmpe275.term.model.BookStatus;

public interface BookStatusDAO {
	public BookStatus issueBooks(BookStatus bookStatus);
	public String returnBooks(String bookStatusId);
	public List<BookStatus> getListOfIssuedBooks(String patronId);
	public BookStatus findBookStatusByISBN(String isbn);
	public void updateBookStatus(BookStatus bookStatus);
	
}
