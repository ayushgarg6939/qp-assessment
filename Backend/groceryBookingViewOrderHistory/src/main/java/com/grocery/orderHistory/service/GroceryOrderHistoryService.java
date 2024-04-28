package com.grocery.orderHistory.service;

import java.util.List;

import com.grocery.orderHistory.model.GroceryBookingHistory;

public interface GroceryOrderHistoryService {

	List<GroceryBookingHistory> viewOrderHistory(String userId);
}
