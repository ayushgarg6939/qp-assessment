package com.grocery.login.repository;

import org.springframework.stereotype.Repository;

import com.grocery.login.model.GroceryAppUsers;
import com.grocery.login.model.GroceryAppUsersPrimaryKey;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GroceryAppUserLoginRepoImpl implements GroceryAppUserLoginRepo{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public GroceryAppUsers checkUser(GroceryAppUsersPrimaryKey user) {
		
		GroceryAppUsers fetchedUser = entityManager.find(GroceryAppUsers.class, user);
		return fetchedUser;
	}

}
