package com.grocery.showUsers.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.showUsers.model.GroceryAppUsers;
import com.grocery.showUsers.repository.GroceryBookingUserListRepo;

@Service
public class GroceryBookingUserListServiceImpl implements GroceryBookingUserListService{

	private GroceryBookingUserListRepo groceryBookingUserListRepo;
	
	public GroceryBookingUserListServiceImpl(GroceryBookingUserListRepo groceryBookingUserListRepo) {
		this.groceryBookingUserListRepo = groceryBookingUserListRepo;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<GroceryAppUsers> userList() {
		return groceryBookingUserListRepo.userList();
	}

}
