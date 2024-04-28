package com.grocery.showUsers.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grocery.showUsers.model.GroceryAppUsers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GroceryBookingUserListRepoImpl implements GroceryBookingUserListRepo {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<GroceryAppUsers> userList() {
		List<GroceryAppUsers> userList = entityManager
				.createQuery("FROM GroceryAppUsers WHERE groceryAppUserRole = 'User'", GroceryAppUsers.class)
				.getResultList();
		return userList;
	}

}
