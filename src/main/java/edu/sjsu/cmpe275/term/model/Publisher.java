package edu.sjsu.cmpe275.term.model;
/**
 * @author Pratik
 *
 */
import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class Publisher implements Serializable {
	private static final long serialVersionUID = 5865760835716664141L;
	@Column(name = "PHONENUMBER")
	private int phoneNumber;
	@Column(name = "PUBLISHER")
	private String publisher;
	@Column(name = "YEAROFPUBLICATION")
	private Date yearOfPublication;
	
	public Publisher() {
		super();
	}

	public Publisher(int phoneNumber, String publisher, Date yearOfPublication) {
		super();
		this.phoneNumber = phoneNumber;
		this.publisher = publisher;
		this.yearOfPublication = yearOfPublication;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getPublisher() {
		return publisher;
	}

	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}

	public Date getYearOfPublication() {
		return yearOfPublication;
	}

	public void setYearOfPublication(Date yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
}
