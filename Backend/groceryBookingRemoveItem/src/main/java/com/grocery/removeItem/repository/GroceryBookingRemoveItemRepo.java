package com.grocery.removeItem.repository;

import com.grocery.removeItem.model.GroceryItems;

public interface GroceryBookingRemoveItemRepo {
	boolean removeGroceryItem(GroceryItems groceryItem);
}
