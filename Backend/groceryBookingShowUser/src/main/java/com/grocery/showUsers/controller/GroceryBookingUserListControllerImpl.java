package com.grocery.showUsers.controller;

import java.util.List;

import org.hibernate.HibernateException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocery.showUsers.model.GroceryAppUsers;
import com.grocery.showUsers.service.GroceryBookingUserListService;


@RestController
@RequestMapping("/groceryApp")
public class GroceryBookingUserListControllerImpl implements GroceryBookingUserListController{

	private GroceryBookingUserListService groceryBookingUserListService;
	
	public GroceryBookingUserListControllerImpl(GroceryBookingUserListService groceryBookingUserListService) {
		this.groceryBookingUserListService = groceryBookingUserListService;
	}
	
	@Override
	@GetMapping("/showUsers")
	public ResponseEntity<List<GroceryAppUsers>> getListOfUser() {
		try {
			return ResponseEntity.status(HttpStatus.OK).body(groceryBookingUserListService.userList());
		}catch(HibernateException hbException) {
			return ResponseEntity.status(HttpStatus.OK).body(null);
		}
	}

}
