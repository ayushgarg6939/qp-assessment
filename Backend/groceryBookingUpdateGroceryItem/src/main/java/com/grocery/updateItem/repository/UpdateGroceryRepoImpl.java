package com.grocery.updateItem.repository;

import org.springframework.stereotype.Repository;

import com.grocery.updateItem.model.GroceryItems;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class UpdateGroceryRepoImpl implements UpdateGroceryRepo{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean updateItem(GroceryItems groceryItem) {
		entityManager.merge(groceryItem);
		return false;
	}

}
