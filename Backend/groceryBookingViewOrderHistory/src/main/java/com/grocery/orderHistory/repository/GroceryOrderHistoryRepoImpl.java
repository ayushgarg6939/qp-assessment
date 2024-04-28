package com.grocery.orderHistory.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grocery.orderHistory.model.GroceryBookingHistory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GroceryOrderHistoryRepoImpl implements GroceryOrderHistoryRepo{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<GroceryBookingHistory> viewOrderHistory(String userId) {
		List<GroceryBookingHistory> orderHistoryList = entityManager.createQuery("FROM GroceryBookingHistory where groceryUserId = :userId", GroceryBookingHistory.class)
				.setParameter("userId", userId)
				.getResultList();
		return orderHistoryList;
	}

}
