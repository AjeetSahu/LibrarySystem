package edu.sjsu.cmpe275.term.model;
import java.util.Date;

public class Book {
	String isbn;
	String author;
	String title;
	int phoneNumber;
	String publisher;
	Date yearOfPublication;
	String location;
	int numberOfCopies;
	boolean currentStatus;
	String[] keywords;
	String coverageImage;
	
	public Book() {
		super();
	}

	public Book(String isbn, String author, String title, int phoneNumber, String publisher, Date yearOfPublication,
			String location, int numberOfCopies, boolean currentStatus, String[] keywords, String coverageImage) {
		super();
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.phoneNumber = phoneNumber;
		this.publisher = publisher;
		this.yearOfPublication = yearOfPublication;
		this.location = location;
		this.numberOfCopies = numberOfCopies;
		this.currentStatus = currentStatus;
		this.keywords = keywords;
		this.coverageImage = coverageImage;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getAuthor() {
		return author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
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

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getNumberOfCopies() {
		return numberOfCopies;
	}

	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}

	public boolean isCurrentStatus() {
		return currentStatus;
	}

	public void setCurrentStatus(boolean currentStatus) {
		this.currentStatus = currentStatus;
	}

	public String[] getKeywords() {
		return keywords;
	}

	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}

	public String getCoverageImage() {
		return coverageImage;
	}

	public void setCoverageImage(String coverageImage) {
		this.coverageImage = coverageImage;
	}
}
