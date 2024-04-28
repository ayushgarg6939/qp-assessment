package com.grocery.orderHistory.repository;

import java.util.List;

import com.grocery.orderHistory.model.GroceryBookingHistory;

public interface GroceryOrderHistoryRepo {

	List<GroceryBookingHistory> viewOrderHistory(String userId);
}
