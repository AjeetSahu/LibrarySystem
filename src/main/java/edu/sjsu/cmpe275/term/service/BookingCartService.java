package edu.sjsu.cmpe275.term.service;

import edu.sjsu.cmpe275.term.model.BookingCart;

public interface BookingCartService {
	
	public BookingCart findBookingCartById(String bookingCartId);

	public BookingCart saveNewBookingCart(BookingCart bookingCart);
	
	public void updateBookingCart(BookingCart bookingCart);
	
	public void deleteBookingCartById(String bookingCartId);
}
