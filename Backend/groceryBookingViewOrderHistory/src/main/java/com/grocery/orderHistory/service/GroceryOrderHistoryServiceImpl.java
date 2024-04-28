package com.grocery.orderHistory.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.orderHistory.model.GroceryBookingHistory;
import com.grocery.orderHistory.repository.GroceryOrderHistoryRepo;

@Service
public class GroceryOrderHistoryServiceImpl implements GroceryOrderHistoryService{

	private GroceryOrderHistoryRepo groceryOrderHistoryRepo;
	
	public GroceryOrderHistoryServiceImpl(GroceryOrderHistoryRepo groceryOrderHistoryRepo) {
		this.groceryOrderHistoryRepo = groceryOrderHistoryRepo;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<GroceryBookingHistory> viewOrderHistory(String userId) {
		
		return groceryOrderHistoryRepo.viewOrderHistory(userId);
	}

}
