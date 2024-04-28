package com.grocery.addToCart.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.addToCart.model.GroceryCartHistory;
import com.grocery.addToCart.repository.RemoveFromCartRepository;

@Service
public class RemoveFromCartServiceImpl implements RemoveFromCartService{

	private RemoveFromCartRepository removeFromCartRepository;
	
	public RemoveFromCartServiceImpl(RemoveFromCartRepository removeFromCartRepository) {
		this.removeFromCartRepository = removeFromCartRepository;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean removeItemFromCart(GroceryCartHistory itemToBeRemovedFromCart) {
		
		return removeFromCartRepository.removeItemFromCart(itemToBeRemovedFromCart);
	}

}
