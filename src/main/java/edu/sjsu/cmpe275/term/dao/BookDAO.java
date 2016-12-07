package edu.sjsu.cmpe275.term.dao;
/**
 * @author Pratik
 *
 */
import edu.sjsu.cmpe275.term.model.Book;

public interface BookDAO {

	public Book findBookByISBN(String isbn);

	public Book saveNewBook(Book book);
	
	public void updateBook(Book book);
	
	public void deleteBookByISBN(String isbn);
	
	//public List<Book> findAllBooks();
}
