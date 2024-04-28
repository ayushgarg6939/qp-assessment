package com.grocery.addToCart.service;

import com.grocery.addToCart.model.GroceryCartHistory;

public interface GroceryAddItemToCartService {
	boolean addItemToCart(GroceryCartHistory groceryCart);
}
