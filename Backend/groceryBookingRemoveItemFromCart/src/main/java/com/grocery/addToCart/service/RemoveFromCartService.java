package com.grocery.addToCart.service;

import com.grocery.addToCart.model.GroceryCartHistory;

public interface RemoveFromCartService {
	boolean removeItemFromCart(GroceryCartHistory itemToBeRemovedFromCart);
}
