package com.grocery.removeItem.repository;

import org.springframework.stereotype.Repository;
import com.grocery.removeItem.model.GroceryItems;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GroceryBookingRemoveItemRepoImpl implements GroceryBookingRemoveItemRepo{

	
	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean removeGroceryItem(GroceryItems groceryItem) {
		GroceryItems itemToRemove = entityManager.find(GroceryItems.class, groceryItem.getGroceryItemName());
		entityManager.remove(itemToRemove);
		return true;
		
	}

}
