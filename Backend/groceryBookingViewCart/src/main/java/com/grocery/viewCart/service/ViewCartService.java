package com.grocery.viewCart.service;

import java.util.List;

import com.grocery.viewCart.model.GroceryCartHistory;

public interface ViewCartService {

	List<GroceryCartHistory> viewCart(String userId);
}
