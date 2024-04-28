package com.grocery.login.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.login.model.GroceryAppUsers;
import com.grocery.login.model.GroceryAppUsersPrimaryKey;
import com.grocery.login.repository.GroceryAppUserLoginRepo;

@Service
public class GroceryAppUserLoginServiceImpl implements GroceryAppUserLoginService{

	private GroceryAppUserLoginRepo groceryAppUserLoginRepo;
	
	public GroceryAppUserLoginServiceImpl(GroceryAppUserLoginRepo groceryAppUserLoginRepo) {
		this.groceryAppUserLoginRepo = groceryAppUserLoginRepo;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public GroceryAppUsers checkUser(GroceryAppUsersPrimaryKey user) {
		return groceryAppUserLoginRepo.checkUser(user);
	}

}
