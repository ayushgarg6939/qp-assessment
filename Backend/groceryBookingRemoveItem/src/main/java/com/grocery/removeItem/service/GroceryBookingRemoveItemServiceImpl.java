package com.grocery.removeItem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.removeItem.model.GroceryItems;
import com.grocery.removeItem.repository.GroceryBookingRemoveItemRepo;

@Service
public class GroceryBookingRemoveItemServiceImpl implements GroceryBookingRemoveItemService{

	private GroceryBookingRemoveItemRepo groceryBookingRemoveItemRepo;
	
	public GroceryBookingRemoveItemServiceImpl(GroceryBookingRemoveItemRepo groceryBookingRemoveItemRepo) {
		this.groceryBookingRemoveItemRepo = groceryBookingRemoveItemRepo;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean removeGroceryItem(GroceryItems groceryItem) {	
		return groceryBookingRemoveItemRepo.removeGroceryItem(groceryItem);
	}

}
