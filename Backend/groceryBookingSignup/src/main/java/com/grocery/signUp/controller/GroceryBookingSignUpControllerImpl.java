package com.grocery.signUp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.signUp.model.GroceryAppUsers;
import com.grocery.signUp.model.ResponceModel;
import com.grocery.signUp.service.GroceryAppSignUpService;

@RestController
@RequestMapping("/groceryApp")
public class GroceryBookingSignUpControllerImpl implements GroceryBookingSignUpController{

	private GroceryAppSignUpService groceryAppSignUpService;
	
	public GroceryBookingSignUpControllerImpl(GroceryAppSignUpService groceryAppSignUpService) {
		this.groceryAppSignUpService = groceryAppSignUpService;
	}
	
	@Override
	@PostMapping("/signUp")
	public ResponseEntity<ResponceModel> signupUser(@RequestBody GroceryAppUsers user) {
		ResponceModel responceModel = new ResponceModel();
		boolean isUserCreated = groceryAppSignUpService.signUpUser(user);
		if(isUserCreated) {
			responceModel.setResponceStatus("Success");
		}else {
			responceModel.setResponceStatus("Failed");
		}
		return ResponseEntity.status(HttpStatus.OK).body(responceModel);
	}

}
