package com.grocery.addItem.controller;

import org.springframework.http.ResponseEntity;

import com.grocery.addItem.model.GroceryItems;
import com.grocery.addItem.model.ResponceModel;

public interface GroceryBookingAddItemController {

	ResponseEntity<ResponceModel> addNewItem(GroceryItems groceryItems); 
}
