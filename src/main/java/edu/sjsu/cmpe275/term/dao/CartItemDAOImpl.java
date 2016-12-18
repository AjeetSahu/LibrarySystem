package edu.sjsu.cmpe275.term.dao;

import edu.sjsu.cmpe275.term.model.BookingCart;
import edu.sjsu.cmpe275.term.model.CartItem;

public class CartItemDAOImpl  extends AbstractDao<String, CartItem> implements CartItemDAO {

	@Override
	public CartItem findCartItemById(String CartItemId) {
		return findById(CartItemId);
	}

	@Override
	public CartItem saveNewCartItem(CartItem CartItem) {
		return save(CartItem);
	}

	@Override
	public void updateCartItem(CartItem CartItem) {
		update(CartItem);
	}

	@Override
	public void deleteCartItemById(String CartItemId) {
		deleteById(CartItemId);
	}

	@Override
	public CartItem findCartItemByBookId(String BookId) {
		return findById(BookId);
	}

}
