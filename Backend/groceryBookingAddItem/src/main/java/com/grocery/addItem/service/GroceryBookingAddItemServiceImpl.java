package com.grocery.addItem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.addItem.model.GroceryItems;
import com.grocery.addItem.repository.GroceryBookingAddItemRepo;

@Service
public class GroceryBookingAddItemServiceImpl implements GroceryBookingAddItemService{

	private GroceryBookingAddItemRepo groceryBookingAddItemRepo;
	
	public GroceryBookingAddItemServiceImpl(GroceryBookingAddItemRepo groceryBookingAddItemRepo) {
		this.groceryBookingAddItemRepo = groceryBookingAddItemRepo;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean addGroceryItem(GroceryItems groceryItems) {
		return groceryBookingAddItemRepo.addGroceryItem(groceryItems);
	}

}
