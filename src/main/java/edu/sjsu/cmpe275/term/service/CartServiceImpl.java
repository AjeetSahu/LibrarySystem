package edu.sjsu.cmpe275.term.service;

import org.springframework.beans.factory.annotation.Autowired;

import edu.sjsu.cmpe275.term.dao.CartDAO;
import edu.sjsu.cmpe275.term.model.BookingCart;

public class CartServiceImpl implements CartService {
	
	@Autowired
	private CartDAO cartDAO;
	
	public void setCartDAO(CartDAO cartDAO) {
		this.cartDAO = cartDAO;
	}

	@Override
	public BookingCart findBookingCartById(String bookingCartId) {
		return cartDAO.findBookingCartById(bookingCartId);
	}

	@Override
	public BookingCart saveNewBookingCart(BookingCart bookingCart) {
		return cartDAO.saveNewBookingCart(bookingCart);
	}

	@Override
	public void updateBookingCart(BookingCart bookingCart) {
		cartDAO.updateBookingCart(bookingCart);
	}

	@Override
	public void deleteBookingCartById(String bookingCartId) {
		cartDAO.deleteBookingCartById(bookingCartId);
	}

}
