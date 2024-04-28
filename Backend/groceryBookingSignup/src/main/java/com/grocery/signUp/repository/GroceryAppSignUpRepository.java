package com.grocery.signUp.repository;

import com.grocery.signUp.model.GroceryAppUsers;

public interface GroceryAppSignUpRepository {
	boolean signUpUser(GroceryAppUsers user);
}
