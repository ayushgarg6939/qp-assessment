package com.grocery.addToCart.controller;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.addToCart.model.GroceryCartHistory;
import com.grocery.addToCart.model.ResponceModel;
import com.grocery.addToCart.service.GroceryAddItemToCartService;

@RestController
@RequestMapping("/groceryApp")
public class GroceryAddItemToCartControllerImpl implements GroceryAddItemToCartController{

	private GroceryAddItemToCartService groceryAddItemToCartService;
	
	public GroceryAddItemToCartControllerImpl(GroceryAddItemToCartService groceryAddItemToCartService) {
		this.groceryAddItemToCartService = groceryAddItemToCartService;
	}
	
	@Override
	@PutMapping("/addItemToCart")
	public ResponseEntity<ResponceModel> addItemToCart(@RequestBody GroceryCartHistory groceryCart) {
		ResponceModel responce = new ResponceModel();
		try {
			groceryAddItemToCartService.addItemToCart(groceryCart);
			responce.setResponceStatus("Success");
		}catch(HibernateException hbException) {
			responce.setResponceStatus("Failed");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responce);
	}

}
