package edu.sjsu.cmpe275.term.model;
/**
 * @author Pratik
 *
 */
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OrderColumn;
import javax.persistence.PrePersist;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class BookStatus implements Serializable {
	private static final long serialVersionUID = 5865760835716664141L;
	@Id
	@Column(name = "BOOKSTATUSID")
	private String bookStatusId;
	@PrePersist
	private void generateSecret(){
		this.setBookStatusId(UUID.randomUUID().toString());
	}
	@Column(name = "ISUUEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date issueDate;
	@Column(name = "DUEDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date dueDate;
	@Column(name = "RETURNDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date returnDate;
	@Column(name = "REQUESTDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date requestDate;
	@Column(name = "REQUESTSTATUS")
	private String requestStatus;
	@Column(name = "ASSIGNEDDATE")
	@Temporal(TemporalType.TIMESTAMP)
	private Date assignedDate;
	
	@ManyToOne
	@JoinColumn(name="BOOKID")
	private Book book;
	
	
	//@ManyToMany(mappedBy="bookStatus")
	//private List<Patron> patrons=new ArrayList<Patron>();
	

	@ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="PATRON_BOOKSTATUS", joinColumns={@JoinColumn(name="bookStatusId", referencedColumnName = "bookStatusId")},
	inverseJoinColumns={@JoinColumn(name="email", referencedColumnName= "email")})
	private List<Patron> patrons=new ArrayList<Patron>();
	
	
	public BookStatus() {
		super();
	}
	/**
	 * 
	 * @param bookStatusId
	 * @param issueDate
	 * @param dueDate
	 * @param returnDate
	 * @param requestDate
	 * @param requestStatus
	 * @param assignedDate
	 * @param book
	 * @param patrons
	 * @param librarians
	 */
	public BookStatus(String bookStatusId, Date issueDate, Date dueDate, Date returnDate, Date requestDate,
			String requestStatus, Date assignedDate, Book book, List<Patron> patrons, List<Librarian> librarians) {
		super();
		this.bookStatusId = bookStatusId;
		this.issueDate = issueDate;
		this.dueDate = dueDate;
		this.returnDate = returnDate;
		this.requestDate = requestDate;
		this.assignedDate = assignedDate;
		this.requestStatus = requestStatus;
		this.book = book;
		this.patrons = patrons;
	}
	/**
	 * 
	 * @return
	 */
	public Date getIssueDate() {
		return issueDate;
	}
	/**
	 * 
	 * @param issueDate
	 */
	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}
	/**
	 * 
	 * @return
	 */
	public Date getReturnDate() {
		return returnDate;
	}
	/**
	 * 
	 * @return
	 */
	public Date getDueDate() {
		return dueDate;
	}
	/**
	 * 
	 * @param dueDate
	 */
	public void setDueDate(Date dueDate) {
		this.dueDate = dueDate;
	}
	/**
	 * 
	 * @return
	 */
	public Date getAssignedDate() {
		return assignedDate;
	}
	/**
	 * 
	 * @param assignedDate
	 */
	public void setAssignedDate(Date assignedDate) {
		this.assignedDate = assignedDate;
	}
	/**
	 * 
	 * @param returnDate
	 */
	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}
	/**
	 * 
	 * @return
	 */
	public Date getRequestDate() {
		return requestDate;
	}
	/**
	 * 
	 * @param requestDate
	 */
	public void setRequestDate(Date requestDate) {
		this.requestDate = requestDate;
	}
	/**
	 * 
	 * @return
	 */
	public String getRequestStatus() {
		return requestStatus;
	}
	/**
	 * 
	 * @param requestStatus
	 */
	public void setRequestStatus(String requestStatus) {
		this.requestStatus = requestStatus;
	}
	/**
	 * 
	 * @return
	 */
	public String getBookStatusId() {
		return bookStatusId;
	}
	/**
	 * 
	 * @param bookStatusId
	 */
	public void setBookStatusId(String bookStatusId) {
		this.bookStatusId = bookStatusId;
	}
	/**
	 * 
	 * @return
	 */
	public Book getBook() {
		return book;
	}
	/**
	 * 
	 * @param book
	 */
	public void setBook(Book book) {
		this.book = book;
	}
	/**
	 * 
	 * @return
	 */
	public List<Patron> getPatrons() {
		return patrons;
	}
	/**
	 * 
	 * @param patrons
	 */
	public void setPatrons(List<Patron> patrons) {
		this.patrons = patrons;
	}	
}
