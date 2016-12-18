package edu.sjsu.cmpe275.term.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.term.dao.BookingCartDAO;
import edu.sjsu.cmpe275.term.model.BookingCart;

public class BookingCartServiceImpl implements BookingCartService {
	
	@Autowired
	private BookingCartDAO bookingCartDAO;
	
	public void setBookingCartDAO(BookingCartDAO bookingCartDAO) {
		this.bookingCartDAO = bookingCartDAO;
	}

	@Override
	public BookingCart findBookingCartById(String bookingCartId) {
		return bookingCartDAO.findBookingCartById(bookingCartId);
	}

	@Override
	public BookingCart saveNewBookingCart(BookingCart bookingCart) {
		return bookingCartDAO.saveNewBookingCart(bookingCart);
	}

	@Override
	public void updateBookingCart(BookingCart bookingCart) {
		bookingCartDAO.updateBookingCart(bookingCart);
	}

	@Override
	public void deleteBookingCartById(String bookingCartId) {
		bookingCartDAO.deleteBookingCartById(bookingCartId);
	}

}
