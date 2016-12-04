package edu.sjsu.cmpe275.term.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.sjsu.cmpe275.term.dao.BookDAO;
import edu.sjsu.cmpe275.term.model.Book;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	private BookDAO bookDAO;
	
	public void setBookDAO(BookDAO bookDAO) {
		this.bookDAO = bookDAO;
	}

	@Override
	public Book findBookByISBN(String isbn) {
		return bookDAO.findBookByISBN(isbn);
	}

	@Override
	public Book saveNewBook(Book book) {
		return bookDAO.saveNewBook(book);
	}

	@Override
	public void deleteBookByISBN(String isbn) {
		bookDAO.deleteBookByISBN(isbn);
	}

	@Override
	public List<Book> getAllIssuedBookByPatronId(String patronId) {
		return bookDAO.getAllIssuedBookByPatronId(patronId);
	}

	@Override
	public void updateBook(Book book) {
		bookDAO.updateBook(book);	
	}

}
