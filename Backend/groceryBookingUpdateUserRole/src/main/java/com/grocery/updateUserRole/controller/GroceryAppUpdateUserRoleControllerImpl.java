package com.grocery.updateUserRole.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.updateUserRole.model.GroceryAppUsers;
import com.grocery.updateUserRole.model.ResponceModel;
import com.grocery.updateUserRole.service.GroceryAppUpdateUserRoleService;

@RestController
@RequestMapping("/groceryApp")
public class GroceryAppUpdateUserRoleControllerImpl implements GroceryAppUpdateUserRoleController{

	private GroceryAppUpdateUserRoleService groceryAppUpdateUserRoleService;
	
	public GroceryAppUpdateUserRoleControllerImpl(GroceryAppUpdateUserRoleService groceryAppUpdateUserRoleService) {
		this.groceryAppUpdateUserRoleService = groceryAppUpdateUserRoleService;
	}
	
	@Override
	@PutMapping("/updateUser")
	public ResponseEntity<ResponceModel> updateUserRole(@RequestBody GroceryAppUsers user) {
		ResponceModel responce = new ResponceModel();
		boolean isUserUpdated = groceryAppUpdateUserRoleService.updateUerRole(user);
		if(isUserUpdated) {
			responce.setResponceStatus("Success");
		}else {
			responce.setResponceStatus("Failed");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responce);
	}

	

}
