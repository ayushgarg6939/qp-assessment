package com.grocery.addToCart.controller;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.addToCart.model.GroceryCartHistory;
import com.grocery.addToCart.model.ResponceModel;
import com.grocery.addToCart.service.RemoveFromCartService;

@RestController
@RequestMapping("/groceryApp")
public class RemoveFromCartControllerImpl implements RemoveFromCartController{

	private RemoveFromCartService removeFromCartService;
	
	public RemoveFromCartControllerImpl(RemoveFromCartService removeFromCartService) {
		this.removeFromCartService = removeFromCartService;
	}
	
	@Override
	@PostMapping("/removeItemFromCart")
	public ResponseEntity<ResponceModel> removeFromCart(@RequestBody GroceryCartHistory itemToBeRemovedFromCart) {
		ResponceModel responce = new ResponceModel();
		try {
			removeFromCartService.removeItemFromCart(itemToBeRemovedFromCart);
			responce.setResponceStatus("Success");
		}catch(HibernateException hbException) {
			responce.setResponceStatus("Failed");
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(responce);
	}

}
