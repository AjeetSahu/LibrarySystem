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
	/**
	 * 
	 * @param phoneNumber
	 * @param publisher
	 * @param yearOfPublication
	 */
	public Publisher(int phoneNumber, String publisher, Date yearOfPublication) {
		super();
		this.phoneNumber = phoneNumber;
		this.publisher = publisher;
		this.yearOfPublication = yearOfPublication;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * 
	 * @param phoneNumber
	 */
	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * 
	 * @return
	 */
	public String getPublisher() {
		return publisher;
	}
	/**
	 * 
	 * @param publisher
	 */
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	/**
	 * 
	 * @return
	 */
	public Date getYearOfPublication() {
		return yearOfPublication;
	}
	/**
	 * 
	 * @param yearOfPublication
	 */
	public void setYearOfPublication(Date yearOfPublication) {
		this.yearOfPublication = yearOfPublication;
	}
}
