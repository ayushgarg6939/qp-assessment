package com.grocery.removeItem.controller;

import org.springframework.http.ResponseEntity;

import com.grocery.removeItem.model.GroceryItems;
import com.grocery.removeItem.model.ResponceModel;

public interface GroceryBookingRemoveItemController {
	ResponseEntity<ResponceModel> deleteGrocery(GroceryItems groceryItem);
}
