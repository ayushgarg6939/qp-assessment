package com.grocery.bookItem.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.bookItem.model.GroceryCartHistory;
import com.grocery.bookItem.model.ResponceModel;
import com.grocery.bookItem.service.ConfirmBookingService;

@RestController
@RequestMapping("/groceryApp")
public class BookItemsControllerImpl implements BookItemsController{

	private ConfirmBookingService confirmBookingService;
	
	public BookItemsControllerImpl(ConfirmBookingService confirmBookingService) {
		this.confirmBookingService = confirmBookingService;
	}
	
	@Override
	@GetMapping("/confirmBooking/{userId}")
	public ResponseEntity<ResponceModel> completeBooking(@PathVariable String userId) {
		ResponceModel responce = new ResponceModel();
		List<GroceryCartHistory> cartItemsList = confirmBookingService.fetchCartDetails(userId);
		try {
			double bookingPrice = confirmBookingService.confirmBooking(cartItemsList);
			responce.setResponceStatus(String.valueOf(bookingPrice));
		}catch(HibernateException hbException) {
			responce.setResponceStatus("Failed");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responce);
	}

	
}
