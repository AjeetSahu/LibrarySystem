package edu.sjsu.cmpe275.term.model;

public class Patron {
	int universityId;
	String email;
	String firstName;
	String lastName;
	int totalIssuedCount;
	int dayIssuedCount;
	int penalty;
	int phoneNumber;
	boolean status; //activation
	
	public Patron() {
		super();
	}

	public Patron(int universityId, String email, String firstName, String lastName, int totalIssuedCount,
			int dayIssuedCount, int penalty, int phoneNumber, boolean status) {
		super();
		this.universityId = universityId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
		this.totalIssuedCount = totalIssuedCount;
		this.dayIssuedCount = dayIssuedCount;
		this.penalty = penalty;
		this.phoneNumber = phoneNumber;
		this.status = status;
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
}
