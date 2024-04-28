package com.grocery.viewItem.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grocery.viewItem.model.GroceryItems;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GroceryAppViewItemsRepoImpl implements GroceryAppViewItemsRepo{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public List<GroceryItems> viewAllItems() {
		List<GroceryItems> allAvailableItems = entityManager.createQuery("FROM GroceryItems", GroceryItems.class).getResultList();
		return allAvailableItems;
	}

}
