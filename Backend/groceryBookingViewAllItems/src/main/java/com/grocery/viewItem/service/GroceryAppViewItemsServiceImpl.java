package com.grocery.viewItem.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.viewItem.model.GroceryItems;
import com.grocery.viewItem.repository.GroceryAppViewItemsRepo;

@Service
public class GroceryAppViewItemsServiceImpl implements GroceryAppViewItemsService{

	private GroceryAppViewItemsRepo groceryAppViewItemsRepo;
	
	public GroceryAppViewItemsServiceImpl(GroceryAppViewItemsRepo groceryAppViewItemsRepo) {
		this.groceryAppViewItemsRepo = groceryAppViewItemsRepo;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<GroceryItems> viewAllItems() {
		return groceryAppViewItemsRepo.viewAllItems();
	}

}
