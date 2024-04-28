package com.grocery.addToCart.controller;

import org.springframework.http.ResponseEntity;

import com.grocery.addToCart.model.GroceryCartHistory;
import com.grocery.addToCart.model.ResponceModel;

public interface GroceryAddItemToCartController {
	
	ResponseEntity<ResponceModel> addItemToCart(GroceryCartHistory groceryCart);
}
