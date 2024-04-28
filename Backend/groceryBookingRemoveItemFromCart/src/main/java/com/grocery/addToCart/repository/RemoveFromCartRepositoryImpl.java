package com.grocery.addToCart.repository;

import org.springframework.stereotype.Repository;

import com.grocery.addToCart.model.GroceryCartHistory;
import com.grocery.addToCart.model.GroceryCartHistoryPrimaryKey;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class RemoveFromCartRepositoryImpl implements RemoveFromCartRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean removeItemFromCart(GroceryCartHistory itemToBeRemovedFromCart) {
		
		GroceryCartHistoryPrimaryKey itemKey = new GroceryCartHistoryPrimaryKey();
		itemKey.setGroceryItemName(itemToBeRemovedFromCart.getGroceryItemName());
		itemKey.setGroceryUserId(itemToBeRemovedFromCart.getGroceryUserId());
		GroceryCartHistory itemToBeRemoved = entityManager.find(GroceryCartHistory.class, itemKey);
		
		if(itemToBeRemoved != null) {
			entityManager.remove(itemToBeRemoved);
		}
		
		return true;
	}

}
