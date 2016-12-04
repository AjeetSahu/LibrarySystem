package edu.sjsu.cmpe275.term.service;

import java.util.List;
import edu.sjsu.cmpe275.term.model.Book;

public interface BookService {

	public Book findBookByISBN(String isbn);

	public void saveNewBook(Book book);
	
	public void updateBook(Book book);
	
	public void deleteBookByISBN(String isbn);
	
	//public List<Book> findAllBooks();
	
	public List<Book> getAllIssuedBookByPatronId(String patronId);
}
