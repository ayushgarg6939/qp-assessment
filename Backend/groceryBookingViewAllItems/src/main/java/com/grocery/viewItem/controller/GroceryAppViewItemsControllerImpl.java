package com.grocery.viewItem.controller;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.viewItem.model.GroceryItems;
import com.grocery.viewItem.service.GroceryAppViewItemsService;

@RestController
@RequestMapping("/groceryApp")
public class GroceryAppViewItemsControllerImpl implements GroceryAppViewItemsController{

	private GroceryAppViewItemsService groceryAppViewItemsService;
	
	public GroceryAppViewItemsControllerImpl(GroceryAppViewItemsService groceryAppViewItemsService) {
		this.groceryAppViewItemsService = groceryAppViewItemsService;
	}
	
	@Override
	@GetMapping("/viewAllItems")
	public ResponseEntity<List<GroceryItems>> viewAllItems() {
		
		try {
			return ResponseEntity.status(HttpStatus.OK).body(groceryAppViewItemsService.viewAllItems());
		}catch(HibernateException exception) {
			return ResponseEntity.status(HttpStatus.OK).body(new ArrayList<GroceryItems>());
		}
		
	}

	
}
