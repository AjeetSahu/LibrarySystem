package edu.sjsu.cmpe275.term.dao;
/**
 * @author Pratik
 *
 */
import org.springframework.stereotype.Repository;
import edu.sjsu.cmpe275.term.dao.AbstractDao;
import edu.sjsu.cmpe275.term.model.Book;

@Repository
public class BookDAOImpl extends AbstractDao<String, Book> implements BookDAO{

	@Override
	public Book findBookByISBN(String isbn) {
		return findById(isbn);
	}

	@Override
	public Book saveNewBook(Book book) {
		return save(book);
	}

	@Override
	public void deleteBookByISBN(String isbn) {
		 deleteById(isbn);
	}

	@Override
	public void updateBook(Book book) {
		update(book);		
	}

}