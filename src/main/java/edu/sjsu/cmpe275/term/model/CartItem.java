package edu.sjsu.cmpe275.term.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrePersist;

@Entity
public class CartItem implements Serializable {
    private static final long serialVersionUID = 5865760835716664141L;
	@Id
	@Column(name = "CARTITEMID")
	private String cartItemId;
	@PrePersist
	private void generateSecret(){
		this.setCartItemId(UUID.randomUUID().toString());
	}
    @OneToOne(cascade = CascadeType.MERGE, fetch=FetchType.LAZY)
	@JoinColumn(name="BOOKID")
    private Book book;
    private int quantity;
    
    @ManyToOne
	@JoinColumn(name="BOOKINGCARTID")
	private BookingCart bookCartId;
    
    public CartItem() {
    }
    
    public CartItem(Book book, int quantity) {
    	super();
    	this.book = book;
        this.quantity = quantity;
    }

    public CartItem(Book book, int quantity, BookingCart bookCartId) {
    	super();
    	this.book = book;
        this.quantity = quantity;
        this.bookCartId = bookCartId;
    }

	public CartItem(String cartItemId, Book book, int quantity, BookingCart bookCartId) {
		super();
		this.cartItemId = cartItemId;
		this.book = book;
		this.quantity = quantity;
		this.bookCartId = bookCartId;
	}

	public String getCartItemId() {
		return cartItemId;
	}

	public void setCartItemId(String cartItemId) {
		this.cartItemId = cartItemId;
	}

	public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public BookingCart getBookCartId() {
		return bookCartId;
	}

	public void setBookCartId(BookingCart bookCartId) {
		this.bookCartId = bookCartId;
	}

	public void increaseQuantity() {
        quantity++;
    }
}
