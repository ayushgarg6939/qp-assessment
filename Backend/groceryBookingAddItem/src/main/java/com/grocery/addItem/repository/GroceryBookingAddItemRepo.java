package com.grocery.addItem.repository;

import com.grocery.addItem.model.GroceryItems;

public interface GroceryBookingAddItemRepo {

	boolean addGroceryItem(GroceryItems groceryItems);
}
