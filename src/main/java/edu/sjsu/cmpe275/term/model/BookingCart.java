package edu.sjsu.cmpe275.term.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.PrePersist;

@Entity
public class BookingCart implements Serializable {
    private static final long serialVersionUID = 5865760835716664141L;
    @Id
	@Column(name = "BOOKINGCARTID")
	private String bookingCartId;
	@PrePersist
	private void generateSecret(){
		this.setBookingCartId(UUID.randomUUID().toString());
	}
	@ManyToMany
    private List<Book> Books;
    private int totalQuantity;
    
    public BookingCart() {
        Books = new ArrayList<Book>();
        totalQuantity = 0;
    }
        
    public BookingCart(List<Book> books, int totalQuantity) {
		super();
		Books = books;
		this.totalQuantity = totalQuantity;
	}

	public String getBookingCartId() {
		return bookingCartId;
	}
    
	public void setBookingCartId(String bookingCartId) {
		this.bookingCartId = bookingCartId;
	}

	public synchronized List<Book> getBooks() {
        return Books;
    }

    public synchronized void setBooks(List<Book> Books) {
        this.Books = Books;
    }

    public synchronized int getTotalQuantity() {
        return totalQuantity;
    }

    public synchronized void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public synchronized void addCartItem(Book Book) {
        for (Book item : Books) {
            if (Book.getIsbn().equalsIgnoreCase(item.getIsbn())){
                item.increaseQuantity();
                return;
            }
        }
        Books.add(Book);
    }

    public synchronized void removeCartItemByISBN(String id) {
        Iterator<Book> iterator = Books.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().getIsbn().equalsIgnoreCase(id)){
                iterator.remove();
                break;
            }
        }
    }

    public synchronized void clearCart() {
        this.Books.clear();
    }
}
