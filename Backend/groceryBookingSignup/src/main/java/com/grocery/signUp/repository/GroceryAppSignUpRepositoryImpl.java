package com.grocery.signUp.repository;

import org.springframework.stereotype.Repository;

import com.grocery.signUp.model.GroceryAppUsers;
import com.grocery.signUp.model.GroceryAppUsersPrimaryKey;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GroceryAppSignUpRepositoryImpl implements GroceryAppSignUpRepository{

	@PersistenceContext
	EntityManager entityManager;
	
	@Override
	public boolean signUpUser(GroceryAppUsers user) {
		GroceryAppUsersPrimaryKey primaryKey = new GroceryAppUsersPrimaryKey();
		primaryKey.setGroceryAppUserName(user.getGroceryAppUserName());
		primaryKey.setGroceryAppUserPassword(user.getGroceryAppUserPassword());
		GroceryAppUsers oldUser = entityManager.find(GroceryAppUsers.class, primaryKey);
		if(oldUser == null) {
			entityManager.persist(user);
			return true;
		}
		return false;
	}

}
