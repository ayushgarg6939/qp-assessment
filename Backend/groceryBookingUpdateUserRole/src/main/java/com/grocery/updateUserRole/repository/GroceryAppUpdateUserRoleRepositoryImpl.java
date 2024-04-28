package com.grocery.updateUserRole.repository;

import org.springframework.stereotype.Repository;

import com.grocery.updateUserRole.model.GroceryAppUsers;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class GroceryAppUpdateUserRoleRepositoryImpl implements GroceryAppUpdateUserRoleRepository{

	@PersistenceContext
	EntityManager entityMnager;
	
	@Override
	public boolean updateUerRole(GroceryAppUsers user) {
		entityMnager.merge(user);
		return true;
	}

}
