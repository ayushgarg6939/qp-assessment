package com.grocery.bookItem.service;

import java.util.List;

import com.grocery.bookItem.model.GroceryCartHistory;

public interface ConfirmBookingService {

	List<GroceryCartHistory> fetchCartDetails(String userId);
	double confirmBooking(List<GroceryCartHistory> cartItemsList);
	
}
