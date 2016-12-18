package edu.sjsu.cmpe275.term.dao;

import edu.sjsu.cmpe275.term.model.CartItem;

public interface CartItemDAO {
	public CartItem findCartItemById(String CartItemId);

	public CartItem saveNewCartItem(CartItem CartItem);
	
	public void updateCartItem(CartItem CartItem);
	
	public void deleteCartItemById(String CartItemId);
	
	public CartItem findCartItemByBookId(String BookId);
}
