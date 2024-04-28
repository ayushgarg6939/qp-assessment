package com.grocery.viewCart.repository;

import java.util.List;

import com.grocery.viewCart.model.GroceryCartHistory;

public interface ViewCartRepository {

	List<GroceryCartHistory> viewCart(String userId);
}
