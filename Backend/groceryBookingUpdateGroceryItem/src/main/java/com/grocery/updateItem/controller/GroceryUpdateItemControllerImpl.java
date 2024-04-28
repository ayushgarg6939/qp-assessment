package com.grocery.updateItem.controller;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.updateItem.model.GroceryItems;
import com.grocery.updateItem.model.ResponceModel;
import com.grocery.updateItem.service.UpdateGroceryService;

@RestController
@RequestMapping("/groceryApp")
public class GroceryUpdateItemControllerImpl implements GroceryUpdateItemController{

	private UpdateGroceryService updateGroceryService;
	
	public GroceryUpdateItemControllerImpl(UpdateGroceryService updateGroceryService) {
		this.updateGroceryService = updateGroceryService;
	}
	
	@Override
	@PutMapping("/updateGrocery")
	public ResponseEntity<ResponceModel> updateItem(@RequestBody GroceryItems groceryItem) {
		ResponceModel responce = new ResponceModel();
		try {
			updateGroceryService.updateItem(groceryItem);
			responce.setResponceStatus("Success");
		}catch(HibernateException hbException) {
			responce.setResponceStatus("Failed");
		}

		return ResponseEntity.status(HttpStatus.OK).body(responce);
	}
	
}
