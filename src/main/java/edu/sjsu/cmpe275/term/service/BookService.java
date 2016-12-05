package edu.sjsu.cmpe275.term.service;
/**
 * @author Pratik
 *
 */
import java.util.List;
import edu.sjsu.cmpe275.term.model.Book;

public interface BookService {
	/**
	 * 
	 * @param isbn
	 * @return
	 */
	public Book findBookByISBN(String isbn);
	/**
	 * 
	 * @param book
	 * @return
	 */
	public Book saveNewBook(Book book);
	/**
	 * 
	 * @param book
	 */
	public void updateBook(Book book);
	/**
	 * 
	 * @param isbn
	 */
	public void deleteBookByISBN(String isbn);
	
	//public List<Book> findAllBooks();
	/**
	 * 
	 * @param patronId
	 * @return
	 */
	public List<Book> getAllIssuedBookByPatronId(String patronId);
}
