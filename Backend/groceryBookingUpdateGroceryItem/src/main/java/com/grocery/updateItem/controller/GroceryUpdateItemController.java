package com.grocery.updateItem.controller;

import org.springframework.http.ResponseEntity;

import com.grocery.updateItem.model.GroceryItems;
import com.grocery.updateItem.model.ResponceModel;

public interface GroceryUpdateItemController {
	ResponseEntity<ResponceModel> updateItem(GroceryItems groceryItem);
	
}
