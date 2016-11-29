package edu.sjsu.cmpe275.term.model;
import java.util.Date;

public class UserBookMapping {
	int userId;
	int bookId;
	Date issueDate;
	Date returnDate;
	Date requestDate;
	String requestStatus;
	
	public UserBookMapping() {
		super();
	}

	public UserBookMapping(int userId, int bookId, Date issueDate, Date returnDate, Date requestDate,
			String requestStatus) {
		super();
		this.userId = userId;
		this.bookId = bookId;
		this.issueDate = issueDate;
		this.returnDate = returnDate;
		this.requestDate = requestDate;
		this.requestStatus = requestStatus;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
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
}
