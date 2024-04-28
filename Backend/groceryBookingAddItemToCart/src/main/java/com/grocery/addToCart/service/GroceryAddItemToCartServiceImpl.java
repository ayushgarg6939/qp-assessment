package com.grocery.addToCart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.addToCart.model.GroceryCartHistory;
import com.grocery.addToCart.repository.GroceryAddItemToCartRepository;

@Service
public class GroceryAddItemToCartServiceImpl implements GroceryAddItemToCartService{

	private GroceryAddItemToCartRepository groceryAddItemToCartRepository;
	
	public GroceryAddItemToCartServiceImpl(GroceryAddItemToCartRepository groceryAddItemToCartRepository) {
		this.groceryAddItemToCartRepository = groceryAddItemToCartRepository;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean addItemToCart(GroceryCartHistory groceryCart) {
		
		return groceryAddItemToCartRepository.addItemToCart(groceryCart);
	}

}
