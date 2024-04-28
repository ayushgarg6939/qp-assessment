package com.grocery.addToCart.repository;

import com.grocery.addToCart.model.GroceryCartHistory;

public interface RemoveFromCartRepository {

	boolean removeItemFromCart(GroceryCartHistory itemToBeRemovedFromCart);
}
