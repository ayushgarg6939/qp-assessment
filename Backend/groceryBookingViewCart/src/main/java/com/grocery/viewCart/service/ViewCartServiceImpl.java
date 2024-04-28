package com.grocery.viewCart.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.viewCart.model.GroceryCartHistory;
import com.grocery.viewCart.repository.ViewCartRepository;

@Service
public class ViewCartServiceImpl implements ViewCartService{

	private ViewCartRepository viewCartRepository;
	
	public ViewCartServiceImpl(ViewCartRepository viewCartRepository) {
		this.viewCartRepository = viewCartRepository;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<GroceryCartHistory> viewCart(String userId) {
		
		return viewCartRepository.viewCart(userId);
	}

}
