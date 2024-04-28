package com.grocery.login.service;

import com.grocery.login.model.GroceryAppUsers;
import com.grocery.login.model.GroceryAppUsersPrimaryKey;

public interface GroceryAppUserLoginService {
	GroceryAppUsers checkUser(GroceryAppUsersPrimaryKey user);
}
