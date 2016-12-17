package edu.sjsu.cmpe275.term.dao;

import edu.sjsu.cmpe275.term.model.BookingCart;

public class CartDAOImpl extends AbstractDao<String, BookingCart> implements CartDAO {

	@Override
	public BookingCart findBookingCartById(String bookingCartId) {
		return findById(bookingCartId);
	}

	@Override
	public BookingCart saveNewBookingCart(BookingCart bookingCart) {
		return save(bookingCart);
	}

	@Override
	public void updateBookingCart(BookingCart bookingCart) {
		update(bookingCart);		
	}

	@Override
	public void deleteBookingCartById(String bookingCartId) {
		deleteById(bookingCartId);
	}

}
