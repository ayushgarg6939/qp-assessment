package com.grocery.viewCart.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.viewCart.model.GroceryCartHistory;
import com.grocery.viewCart.service.ViewCartService;

@RestController
@RequestMapping("/groceryApp")
public class ViewCartControllerImpl implements ViewCartController{

	private ViewCartService viewCartService;
	
	public ViewCartControllerImpl(ViewCartService viewCartService) {
		this.viewCartService = viewCartService;
	}
	
	@Override
	@GetMapping("/viewCart/{userId}")
	public ResponseEntity<List<GroceryCartHistory>> viewCart(@PathVariable String userId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(viewCartService.viewCart(userId));
		}catch(HibernateException hbException) {
			return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<GroceryCartHistory>());
		}
	}

}
