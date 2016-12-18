package edu.sjsu.cmpe275.term.service;

import org.springframework.beans.factory.annotation.Autowired;
import edu.sjsu.cmpe275.term.dao.CartItemDAO;
import edu.sjsu.cmpe275.term.model.CartItem;

public class CartItemServiceImpl implements CartItemService {
	
	@Autowired
	private CartItemDAO cartItemDAO;

	public void setCartItemDAO(CartItemDAO cartItemDAO) {
		this.cartItemDAO = cartItemDAO;
	}

	@Override
	public CartItem findCartItemById(String CartItemId) {
		return cartItemDAO.findCartItemById(CartItemId);
	}

	@Override
	public CartItem saveNewCartItem(CartItem CartItem) {
		return cartItemDAO.saveNewCartItem(CartItem);
	}

	@Override
	public void updateCartItem(CartItem CartItem) {
		cartItemDAO.updateCartItem(CartItem);
	}

	@Override
	public void deleteCartItemById(String CartItemId) {
		cartItemDAO.deleteCartItemById(CartItemId);
	}

	@Override
	public CartItem findCartItemByBookId(String BookId) {
		return cartItemDAO.findCartItemByBookId(BookId);
	}

}
