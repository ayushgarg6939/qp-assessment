package com.grocery.addToCart.repository;

import org.springframework.stereotype.Repository;

import com.grocery.addToCart.model.GroceryCartHistory;
import com.grocery.addToCart.model.GroceryCartHistoryPrimaryKey;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GroceryAddItemToCartRepositoryImpl implements GroceryAddItemToCartRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean addItemToCart(GroceryCartHistory groceryCart) {
		GroceryCartHistoryPrimaryKey cartKey = new GroceryCartHistoryPrimaryKey();
		cartKey.setGroceryItemName(groceryCart.getGroceryItemName());
		cartKey.setGroceryUserId(groceryCart.getGroceryUserId());
		
		GroceryCartHistory alreadypresentInGroceryCart = entityManager.find(GroceryCartHistory.class, cartKey);
		if(alreadypresentInGroceryCart != null) {
			alreadypresentInGroceryCart.setGroceryItemQuantity(alreadypresentInGroceryCart.getGroceryItemQuantity()+groceryCart.getGroceryItemQuantity());
			entityManager.merge(alreadypresentInGroceryCart);
		}else {
			entityManager.merge(groceryCart);
		}
		return true;
	}

}
