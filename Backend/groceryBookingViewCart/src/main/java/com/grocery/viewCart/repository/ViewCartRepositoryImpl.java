package com.grocery.viewCart.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grocery.viewCart.model.GroceryCartHistory;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ViewCartRepositoryImpl implements ViewCartRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<GroceryCartHistory> viewCart(String userId) {
		
		List<GroceryCartHistory> cartList = entityManager.createQuery("FROM GroceryCartHistory WHERE groceryUserId = :userId", GroceryCartHistory.class)
				.setParameter("userId", userId)
				.getResultList();
		return cartList;
	}

}
