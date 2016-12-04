package edu.sjsu.cmpe275.term.model;
/**
 * @author Pratik
 *
 */
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Embeddable
public class BookStatus implements Serializable {
	private static final long serialVersionUID = 5865760835716664141L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOKSTATUSID")
	private int bookStatusId;
	@Column(name = "ISUUEDATE")
	private Date issueDate;
	@Column(name = "DUEDATE")
	private Date dueDate;
	@Column(name = "RETURNDATE")
	private Date returnDate;
	@Column(name = "REQUESTDATE")
	private Date requestDate;
	@Column(name = "REQUESTSTATUS")
	private String requestStatus;
	@Column(name = "CURRENTDATE")
	private Date currentDate;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="BOOKID")
	private Book book;
	@ManyToMany(mappedBy="bookStatus")
	private List<Patron> patrons;
	
	public BookStatus() {
		super();
	}

	public BookStatus(int bookStatusId, Date issueDate, Date dueDate, Date returnDate, Date requestDate,
			String requestStatus, Date currentDate, Book book, List<Patron> patrons, List<Librarian> librarians) {
		super();
		this.bookStatusId = bookStatusId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.requestDate = requestDate;
		this.currentDate = currentDate;
		this.requestStatus = requestStatus;
		this.book = book;
		this.patrons = patrons;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}
	

	public Date getDueDate() {
		return dueDate;
	}

	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}

	public Date getCurrentDate() {
		return currentDate;
	}

	public void setCurrentDate(Date currentDate) {
		this.currentDate = currentDate;
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
	
	
}
