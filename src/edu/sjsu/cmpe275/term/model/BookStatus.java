package edu.sjsu.cmpe275.term.model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class BookStatus implements Serializable {
	private static final long serialVersionUID = 5865760835716664141L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookStatusId;
	private Date issueDate;
	private Date dueDate;
	private Date returnDate;
	private Date requestDate;
	private String requestStatus;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="book_Id")
	private Book book;
	@ManyToMany(mappedBy="patronId")
	private List<Patron> patrons;
	@ManyToMany(mappedBy="librarianId")
	private List<Librarian> librarians;
	
	public BookStatus() {
		super();
	}

	public BookStatus(int bookStatusId, Date issueDate, Date toReturnDate, Date returnDate, Date requestDate,
			String requestStatus, Book book, List<Patron> patrons, List<Librarian> librarians) {
		super();
		this.bookStatusId = bookStatusId;
		this.issueDate = issueDate;
		this.dueDate = toReturnDate;
		this.returnDate = returnDate;
		this.requestDate = requestDate;
		this.requestStatus = requestStatus;
		this.book = book;
		this.patrons = patrons;
		this.librarians = librarians;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getToReturnDate() {
		return dueDate;
	}

	public void setToReturnDate(Date toReturnDate) {
		this.dueDate = toReturnDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Date getRequestDate() {
		return requestDate;
	}

	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}

	public String getRequestStatus() {
		return requestStatus;
	}

	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}

	public int getBookStatusId() {
		return bookStatusId;
	}

	public void setBookStatusId(int bookStatusId) {
		this.bookStatusId = bookStatusId;
	}

	public Book getBook() {
		return book;
	}

	public void setBook(Book book) {
		this.book = book;
	}

	public List<Patron> getPatrons() {
		return patrons;
	}

	public void setPatrons(List<Patron> patrons) {
		this.patrons = patrons;
	}

	public List<Librarian> getLibrarians() {
		return librarians;
	}

	public void setLibrarians(List<Librarian> librarians) {
		this.librarians = librarians;
	} 		
}
