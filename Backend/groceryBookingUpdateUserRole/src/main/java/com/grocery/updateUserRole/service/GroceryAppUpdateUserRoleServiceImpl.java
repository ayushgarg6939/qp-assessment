package com.grocery.updateUserRole.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.updateUserRole.model.GroceryAppUsers;
import com.grocery.updateUserRole.repository.GroceryAppUpdateUserRoleRepository;

@Service
public class GroceryAppUpdateUserRoleServiceImpl implements GroceryAppUpdateUserRoleService{

	private GroceryAppUpdateUserRoleRepository groceryAppUpdateUserRoleRepository;
	
	public GroceryAppUpdateUserRoleServiceImpl(GroceryAppUpdateUserRoleRepository groceryAppUpdateUserRoleRepository) {
		this.groceryAppUpdateUserRoleRepository = groceryAppUpdateUserRoleRepository;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public boolean updateUerRole(GroceryAppUsers user) {
		return groceryAppUpdateUserRoleRepository.updateUerRole(user);
	}

}
