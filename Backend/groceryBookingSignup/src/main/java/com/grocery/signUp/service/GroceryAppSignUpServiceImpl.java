package com.grocery.signUp.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.signUp.model.GroceryAppUsers;
import com.grocery.signUp.repository.GroceryAppSignUpRepository;

@Service
public class GroceryAppSignUpServiceImpl implements GroceryAppSignUpService{

	private GroceryAppSignUpRepository groceryAppSignUpRepository;
	
	public GroceryAppSignUpServiceImpl(GroceryAppSignUpRepository groceryAppSignUpRepository) {
		this.groceryAppSignUpRepository = groceryAppSignUpRepository;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean signUpUser(GroceryAppUsers user) {
		return groceryAppSignUpRepository.signUpUser(user);
	}

}
