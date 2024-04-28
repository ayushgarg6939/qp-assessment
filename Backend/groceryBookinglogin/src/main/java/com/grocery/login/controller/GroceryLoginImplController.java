package com.grocery.login.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.login.model.GroceryAppUsers;
import com.grocery.login.model.GroceryAppUsersPrimaryKey;
import com.grocery.login.service.GroceryAppUserLoginService;

@RestController
@RequestMapping("/groceryApp")
public class GroceryLoginImplController implements GroceryLoginController{

	private GroceryAppUserLoginService groceryAppUserLoginService;
	
	public GroceryLoginImplController(GroceryAppUserLoginService groceryAppUserLoginService){
		this.groceryAppUserLoginService = groceryAppUserLoginService;
	}
	
	@Override
	@PostMapping("/login")
	public ResponseEntity<GroceryAppUsers> userLogin(@RequestBody GroceryAppUsersPrimaryKey groceryAppUser) {
		GroceryAppUsers currentUser = groceryAppUserLoginService.checkUser(groceryAppUser);
		return ResponseEntity.status(HttpStatus.OK).body(currentUser);
	}

}
