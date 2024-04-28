package com.grocery.addItem.repository;

import org.springframework.stereotype.Repository;

import com.grocery.addItem.model.GroceryItems;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GroceryBookingAddItemRepoImpl implements GroceryBookingAddItemRepo{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean addGroceryItem(GroceryItems groceryItems) {
		entityManager.persist(groceryItems);
		return true;
	}

}
