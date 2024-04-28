package com.grocery.login.repository;

import com.grocery.login.model.GroceryAppUsers;
import com.grocery.login.model.GroceryAppUsersPrimaryKey;

public interface GroceryAppUserLoginRepo {

	GroceryAppUsers checkUser(GroceryAppUsersPrimaryKey user);
}
