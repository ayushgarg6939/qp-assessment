package com.grocery.addItem.controller;

import org.hibernate.HibernateException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.grocery.addItem.model.GroceryItems;
import com.grocery.addItem.model.ResponceModel;
import com.grocery.addItem.service.GroceryBookingAddItemService;

@RestController
@RequestMapping("/groceryApp")
public class GroceryBookingAddItemControllerImpl implements GroceryBookingAddItemController{

	private GroceryBookingAddItemService groceryBookingAddItemService;
	
	public GroceryBookingAddItemControllerImpl(GroceryBookingAddItemService groceryBookingAddItemService) {
		this.groceryBookingAddItemService = groceryBookingAddItemService;
	}
	
	@Override
	@PostMapping("/addItem")
	public ResponseEntity<ResponceModel> addNewItem(@RequestBody GroceryItems groceryItems) {
		ResponceModel responce = new ResponceModel();
		try {
			groceryBookingAddItemService.addGroceryItem(groceryItems);
			responce.setResponceStatus("Success");
		}catch(HibernateException hibernateException) {
			responce.setResponceStatus("Failure");
		}catch(DataIntegrityViolationException dataException) {
			responce.setResponceStatus("Failure");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responce);
	}

}
