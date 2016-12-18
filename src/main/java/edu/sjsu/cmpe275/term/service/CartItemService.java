package edu.sjsu.cmpe275.term.service;

import edu.sjsu.cmpe275.term.model.CartItem;

public interface CartItemService {
	public CartItem findCartItemById(String CartItemId);

	public CartItem saveNewCartItem(CartItem CartItem);
	
	public void updateCartItem(CartItem CartItem);
	
	public void deleteCartItemById(String CartItemId);

	public CartItem findCartItemByBookId(String BookId);
}
