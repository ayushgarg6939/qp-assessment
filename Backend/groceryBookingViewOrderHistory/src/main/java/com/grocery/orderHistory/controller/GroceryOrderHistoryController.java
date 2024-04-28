package com.grocery.orderHistory.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.grocery.orderHistory.model.GroceryBookingHistory;

public interface GroceryOrderHistoryController {

	ResponseEntity<List<GroceryBookingHistory>> getUserOrderHistory(String userId);
}
