package com.grocery.updateUserRole.controller;

import org.springframework.http.ResponseEntity;

import com.grocery.updateUserRole.model.GroceryAppUsers;
import com.grocery.updateUserRole.model.ResponceModel;

public interface GroceryAppUpdateUserRoleController {
	
	ResponseEntity<ResponceModel> updateUserRole(GroceryAppUsers user);
}
