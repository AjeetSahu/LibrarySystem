package edu.sjsu.cmpe275.term.model;

public class Librarian {
	int universityId;
	String email;
	String firstName;
	String lastName;
	boolean status; //activation
	
	public Librarian() {
		super();
	}

	public Librarian(int universityId, String email, String firstName, String lastName, boolean status) {
		super();
		this.universityId = universityId;
		this.email = email;
		this.firstName = firstName;
		this.lastName = lastName;
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

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}	
}
