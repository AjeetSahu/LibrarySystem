package edu.sjsu.cmpe275.term.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Patron implements Serializable {
	private static final long serialVersionUID = 5865760835716664141L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PATRONID")
	private int patronId;
	@Column(name= "UNIVERSITYID", unique=true)
	private int universityId;
	@Column(name = "EMAIL")
	private String email;
	@Column(name = "FIRSTNAME")
	private String firstName;
	@Column(name = "LASTNAME")
	private String lastName;
	@Column(name = "PASSWORD")
	private String password;
	@Column(name = "TOTALISSUEDCOUNT")
	private int totalIssuedCount;
	@Column(name = "DAYISSUEDCOUNT")
	private int dayIssuedCount;
	@Column(name = "PENALTY")
	private int penalty;
	@Column(name = "PHONENUMBER")
	private int phoneNumber;
	@Column(name = "STATUS",  nullable= false, columnDefinition= "boolean default false")
	private boolean status; //activation
	@ManyToMany(cascade = {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinTable(name="PATRON_BOOKSTATUS", joinColumns={@JoinColumn(name="patronId", referencedColumnName = "patronId")},
	inverseJoinColumns={@JoinColumn(name="bookStatusId", referencedColumnName= "bookStatusId")})
	private List<BookStatus> bookStatus;
	
	public Patron() {
		super();
	}

	public Patron(int patronId, int universityId, String email, String firstName, String lastName, String password,
			int totalIssuedCount, int dayIssuedCount, int penalty, int phoneNumber, boolean status,
			List<BookStatus> bookStatus) {
		super();
		this.patronId = patronId;
		this.universityId = universityId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.password = password;
		this.totalIssuedCount = totalIssuedCount;
		this.dayIssuedCount = dayIssuedCount;
		this.penalty = penalty;
		this.phoneNumber = phoneNumber;
		this.status = status;
		this.bookStatus = bookStatus;
	}

	public int getPatronId() {
		return patronId;
	}

	public void setPatronId(int patronId) {
		this.patronId = patronId;
	}

	public int getUniversityId() {
		return universityId;
	}

	public void setUniversityId(int universityId) {
		this.universityId = universityId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getTotalIssuedCount() {
		return totalIssuedCount;
	}

	public void setTotalIssuedCount(int totalIssuedCount) {
		this.totalIssuedCount = totalIssuedCount;
	}

	public int getDayIssuedCount() {
		return dayIssuedCount;
	}

	public void setDayIssuedCount(int dayIssuedCount) {
		this.dayIssuedCount = dayIssuedCount;
	}

	public int getPenalty() {
		return penalty;
	}

	public void setPenalty(int penalty) {
		this.penalty = penalty;
	}

	public int getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public List<BookStatus> getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(List<BookStatus> bookStatus) {
		this.bookStatus = bookStatus;
	}	
}
