package edu.sjsu.cmpe275.term.dao;

import edu.sjsu.cmpe275.term.model.BookingCart;

public class BookingCartDAOImpl extends AbstractDao<String, BookingCart> implements BookingCartDAO {

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
