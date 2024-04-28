package com.grocery.updateItem.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.updateItem.model.GroceryItems;
import com.grocery.updateItem.repository.UpdateGroceryRepo;

@Service
public class UpdateGroceryServiceImpl implements UpdateGroceryService{

	private UpdateGroceryRepo updateGroceryRepo;
	
	public UpdateGroceryServiceImpl(UpdateGroceryRepo updateGroceryRepo) {
		this.updateGroceryRepo = updateGroceryRepo;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean updateItem(GroceryItems groceryItem) {
		
		return updateGroceryRepo.updateItem(groceryItem);
	}

}
