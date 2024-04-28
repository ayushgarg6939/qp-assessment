package com.grocery.viewItem.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.grocery.viewItem.model.GroceryItems;

public interface GroceryAppViewItemsController {
	
	ResponseEntity<List<GroceryItems>> viewAllItems();
}
