package com.grocery.signUp.controller;

import org.springframework.http.ResponseEntity;

import com.grocery.signUp.model.GroceryAppUsers;
import com.grocery.signUp.model.ResponceModel;

public interface GroceryBookingSignUpController {

	ResponseEntity<ResponceModel> signupUser(GroceryAppUsers user);
}
