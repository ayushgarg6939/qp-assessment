package com.grocery.viewCart.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.grocery.viewCart.model.GroceryCartHistory;

public interface ViewCartController {

	ResponseEntity<List<GroceryCartHistory>> viewCart(String userId);
}
