package com.grocery.login.controller;

import org.springframework.http.ResponseEntity;

import com.grocery.login.model.GroceryAppUsers;
import com.grocery.login.model.GroceryAppUsersPrimaryKey;

public interface GroceryLoginController {
	
	ResponseEntity<GroceryAppUsers> userLogin(GroceryAppUsersPrimaryKey groceryAppUser);
}
