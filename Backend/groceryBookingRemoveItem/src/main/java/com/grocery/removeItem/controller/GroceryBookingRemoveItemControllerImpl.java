package com.grocery.removeItem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.removeItem.model.GroceryItems;
import com.grocery.removeItem.model.ResponceModel;
import com.grocery.removeItem.service.GroceryBookingRemoveItemService;

@RestController
@RequestMapping("/groceryApp")
public class GroceryBookingRemoveItemControllerImpl implements GroceryBookingRemoveItemController{

	private GroceryBookingRemoveItemService groceryBookingRemoveItemService;
	
	public GroceryBookingRemoveItemControllerImpl(GroceryBookingRemoveItemService groceryBookingRemoveItemService) {
		this.groceryBookingRemoveItemService = groceryBookingRemoveItemService;
	}
	
	@Override
	@PostMapping("/removeItem")
	public ResponseEntity<ResponceModel> deleteGrocery(@RequestBody GroceryItems groceryItem) {
		ResponceModel responce = new ResponceModel();
		boolean isRemoved = groceryBookingRemoveItemService.removeGroceryItem(groceryItem);
		if(isRemoved == Boolean.TRUE) {
			responce.setResponceStatus("Success");
		}else {
			responce.setResponceStatus("Failed");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responce);
	}

}
