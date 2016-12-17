package edu.sjsu.cmpe275.term.dao;

import edu.sjsu.cmpe275.term.model.BookingCart;

public interface CartDAO {
	
	public BookingCart findBookingCartById(String bookingCartId);

	public BookingCart saveNewBookingCart(BookingCart bookingCart);
	
	public void updateBookingCart(BookingCart bookingCart);
	
	public void deleteBookingCartById(String bookingCartId);

}
