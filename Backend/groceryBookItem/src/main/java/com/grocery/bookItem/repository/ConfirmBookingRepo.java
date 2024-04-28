package com.grocery.bookItem.repository;

import java.util.List;

import com.grocery.bookItem.model.GroceryCartHistory;

public interface ConfirmBookingRepo {
	List<GroceryCartHistory> fetchCartDetails(String userId);
	double confirmBooking(GroceryCartHistory cartItem);
}
