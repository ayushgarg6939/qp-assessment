package com.grocery.orderHistory.controller;

import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.orderHistory.model.GroceryBookingHistory;
import com.grocery.orderHistory.service.GroceryOrderHistoryService;


@RestController
@RequestMapping("/groceryApp")
public class GroceryOrderHistoryControllerImpl implements GroceryOrderHistoryController{

	private GroceryOrderHistoryService groceryOrderHistoryService;
	
	public GroceryOrderHistoryControllerImpl(GroceryOrderHistoryService groceryOrderHistoryService) {
		this.groceryOrderHistoryService = groceryOrderHistoryService;
	}
	
	@Override
	@GetMapping("/orderHistory/{userId}")
	public ResponseEntity<List<GroceryBookingHistory>> getUserOrderHistory(@PathVariable String userId) {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(groceryOrderHistoryService.viewOrderHistory(userId));
		}catch(HibernateException hbException) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
	}

}
