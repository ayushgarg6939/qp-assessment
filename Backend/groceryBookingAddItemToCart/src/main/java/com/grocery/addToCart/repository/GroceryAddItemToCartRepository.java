package com.grocery.addToCart.repository;

import com.grocery.addToCart.model.GroceryCartHistory;

public interface GroceryAddItemToCartRepository {

	boolean addItemToCart(GroceryCartHistory groceryCart);
}
