package edu.sjsu.cmpe275.term.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = 5865760835716664141L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int bookId;
	private String isbn;
	private String author;
	private String title;
	@Embedded
	private Publisher publisher;
	private String location;
	private int numberOfCopies;
	private boolean currentStatus;
	private String[] keywords;
	@OneToOne(cascade = CascadeType.ALL)
	private Picture coverImage;
	@OneToMany(mappedBy="bookStatusId" )
	private List<BookStatus> bookStatus;
	
	public Book() {
		super();
	}

	public Book(int bookId, String isbn, String author, String title, Publisher publisher, String location,
			int numberOfCopies, boolean currentStatus, String[] keywords, Picture coverImage,
			List<BookStatus> bookStatus) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.location = location;
		this.numberOfCopies = numberOfCopies;
		this.currentStatus = currentStatus;
		this.keywords = keywords;
		this.coverImage = coverImage;
		this.bookStatus = bookStatus;
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

	public Publisher getPublisher() {
		return publisher;
	}

	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
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

	public Picture getCoverageImage() {
		return coverImage;
	}

	public void setCoverageImage(Picture coverageImage) {
		this.coverImage = coverageImage;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}

	public Picture getCoverImage() {
		return coverImage;
	}

	public void setCoverImage(Picture coverImage) {
		this.coverImage = coverImage;
	}

	public List<BookStatus> getBookStatus() {
		return bookStatus;
	}

	public void setBookStatus(List<BookStatus> bookStatus) {
		this.bookStatus = bookStatus;
	}
}
