package com.grocery.showUsers.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.grocery.showUsers.model.GroceryAppUsers;

public interface GroceryBookingUserListController {
	ResponseEntity<List<GroceryAppUsers>> getListOfUser();
	
}
