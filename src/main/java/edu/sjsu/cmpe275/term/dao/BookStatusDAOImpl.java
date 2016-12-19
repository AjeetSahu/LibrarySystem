package edu.sjsu.cmpe275.term.dao;

import java.util.List;
import org.springframework.stereotype.Repository;
import edu.sjsu.cmpe275.term.model.BookStatus;

@Repository
public class BookStatusDAOImpl extends AbstractDao<String, BookStatus>  implements BookStatusDAO{
	@Override
	public BookStatus issueBooks(BookStatus bookStatus) {
		return save(bookStatus);
	}
	
	@Override
	public String returnBooks(String bookStatusId) {
		return deleteById(bookStatusId);
	}

	@Override
	public List<BookStatus> getListOfIssuedBooks(String patronId) {
		return getListOfIssuedBook(patronId);
	}

	@Override
	public List<BookStatus> findBookStatusByISBN(String isbn) {
		return (List<BookStatus>) findById(isbn);
	}

	@Override
	public void updateBookStatus(BookStatus bookStatus) {
		update(bookStatus);
	}

	/* (non-Javadoc)
	 * @see edu.sjsu.cmpe275.term.dao.BookStatusDAO#getListOfAllBookStatus()
	 */
	@Override
	public List<BookStatus> getListOfAllBookStatus() {
		// TODO Auto-generated method stub
		return getListOfAllBook();
	}
}

