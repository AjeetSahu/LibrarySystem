package edu.sjsu.cmpe275.term.model;
/**
 * @author Pratik
 *
 */
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Book implements Serializable {
	private static final long serialVersionUID = 5865760835716664141L;

	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "BOOKID")
	private int bookId;
	@Id
	@Column(name = "ISBN")
	private String isbn;
	@Column(name = "AUTHOR")
	private String author;
	@Column(name = "TITLE")
	private String title;
	@Embedded
	private Publisher publisher;
	@Column(name = "LOCATION")
	private String location;
	@Column(name = "NUMBEROFCOPIES")
	private int numberOfCopies;
	@Column(name="AVAILABLECOPIES", nullable= false, columnDefinition= "int default 100")
	private int availableCopies;
	@Column(name="CURRENTSTATUS", nullable= false, columnDefinition= "boolean default false")
	private boolean currentStatus; //available or unavailable
	@Column(name = "KEYWORDS")
	private String[] keywords;
	@OneToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
	@JoinColumn(name="PICTUREID")
	private Picture coverImage;
	@OneToMany(mappedBy="book")
	private List<BookStatus> bookStatus;
	
	public Book() {
		super();
	}
	/**
	 * 
	 * @param bookId
	 * @param isbn
	 * @param author
	 * @param title
	 * @param publisher
	 * @param location
	 * @param numberOfCopies
	 * @param availableCopies
	 * @param currentStatus
	 * @param keywords
	 * @param coverImage
	 * @param bookStatus
	 */
	public Book(int bookId, String isbn, String author, String title, Publisher publisher, String location,
			int numberOfCopies, int availableCopies, boolean currentStatus, String[] keywords, Picture coverImage,
			List<BookStatus> bookStatus) {
		super();
		this.bookId = bookId;
		this.isbn = isbn;
		this.author = author;
		this.title = title;
		this.publisher = publisher;
		this.location = location;
		this.numberOfCopies = numberOfCopies;
		this.availableCopies= availableCopies;
		this.currentStatus = currentStatus;
		this.keywords = keywords;
		this.coverImage = coverImage;
		this.bookStatus = bookStatus;
	}
	/**
	 * 
	 * @return
	 */
	public String getIsbn() {
		return isbn;
	}
	/**
	 * 
	 * @param isbn
	 */
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	/**
	 * 
	 * @return
	 */
	public String getAuthor() {
		return author;
	}
	/**
	 * 
	 * @param author
	 */
	public void setAuthor(String author) {
		this.author = author;
	}
	/**
	 * 
	 * @return
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * 
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * 
	 * @return
	 */
	public Publisher getPublisher() {
		return publisher;
	}
	/**
	 * 
	 * @param publisher
	 */
	public void setPublisher(Publisher publisher) {
		this.publisher = publisher;
	}
	/**
	 * 
	 * @return
	 */
	public String getLocation() {
		return location;
	}
	/**
	 * 
	 * @param location
	 */
	public void setLocation(String location) {
		this.location = location;
	}
	/**
	 * 
	 * @return
	 */
	public int getAvailableCopies() {
		return availableCopies;
	}
	/**
	 * 
	 * @param availableCopies
	 */
	public void setAvailableCopies(int availableCopies) {
		this.availableCopies = availableCopies;
	}
	/**
	 * 
	 * @return
	 */
	public int getNumberOfCopies() {
		return numberOfCopies;
	}
	/**
	 * 
	 * @param numberOfCopies
	 */
	public void setNumberOfCopies(int numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	/**
	 * 
	 * @return
	 */
	public boolean isCurrentStatus() {
		return currentStatus;
	}
	/**
	 * 
	 * @param currentStatus
	 */
	public void setCurrentStatus(boolean currentStatus) {
		this.currentStatus = currentStatus;
	}
	/**
	 * 
	 * @return
	 */
	public String[] getKeywords() {
		return keywords;
	}
	/**
	 * 
	 * @param keywords
	 */
	public void setKeywords(String[] keywords) {
		this.keywords = keywords;
	}
	/**
	 * 
	 * @return
	 */
	public int getBookId() {
		return bookId;
	}
	/**
	 * 
	 * @param bookId
	 */
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	/**
	 * 
	 * @return
	 */
	public Picture getCoverImage() {
		return coverImage;
	}
	/**
	 * 
	 * @param coverImage
	 */
	public void setCoverImage(Picture coverImage) {
		this.coverImage = coverImage;
	}
	/**
	 * 
	 * @return
	 */
	public List<BookStatus> getBookStatus() {
		return bookStatus;
	}
	/**
	 * 
	 * @param bookStatus
	 */
	public void setBookStatus(List<BookStatus> bookStatus) {
		this.bookStatus = bookStatus;
	}
}
