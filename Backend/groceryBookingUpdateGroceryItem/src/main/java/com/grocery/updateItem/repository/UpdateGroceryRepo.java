package com.grocery.updateItem.repository;

import com.grocery.updateItem.model.GroceryItems;

public interface UpdateGroceryRepo {

	boolean updateItem(GroceryItems groceryItem);
}
