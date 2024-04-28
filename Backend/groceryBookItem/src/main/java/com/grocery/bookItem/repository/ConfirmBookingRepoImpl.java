package com.grocery.bookItem.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.grocery.bookItem.model.GroceryBookingHistory;
import com.grocery.bookItem.model.GroceryCartHistory;
import com.grocery.bookItem.model.GroceryItems;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

@Repository
public class ConfirmBookingRepoImpl implements ConfirmBookingRepo {

	@PersistenceContext
	EntityManager entityManager;

	@Override
	public List<GroceryCartHistory> fetchCartDetails(String userId) {
		List<GroceryCartHistory> cartList = entityManager
				.createQuery("FROM GroceryCartHistory WHERE groceryUserId = :groceryUserId", GroceryCartHistory.class)
				.setParameter("groceryUserId", userId)
				.getResultList();
		return cartList;
	}

	@Override
	public double confirmBooking(GroceryCartHistory cartItem) {
		GroceryItems item = entityManager.find(GroceryItems.class, cartItem.getGroceryItemName());
		if(cartItem.getGroceryItemQuantity() > item.getGroceryItemInventorySize() && item.getGroceryItemInventorySize()>0) {
			cartItem.setGroceryItemQuantity(item.getGroceryItemInventorySize());
		}else if(item.getGroceryItemInventorySize()<=0){
			return 0;
		}
		GroceryBookingHistory confirmBookingItem = new GroceryBookingHistory();
		confirmBookingItem.setGroceryUserId(cartItem.getGroceryUserId());
		confirmBookingItem.setGroceryItemName(cartItem.getGroceryItemName());
		confirmBookingItem.setGroceryItemQuantity(cartItem.getGroceryItemQuantity());
		confirmBookingItem.setGroceryItemPrice(item.getGroceryItemPrize());
		confirmBookingItem.setGroceryBookingDate(java.time.LocalDate.now());
		confirmBookingItem.setGroceryImageUrl(item.getImgUrl());
		entityManager.persist(confirmBookingItem);
		entityManager.remove(cartItem);
		item.setGroceryItemInventorySize(item.getGroceryItemInventorySize() - cartItem.getGroceryItemQuantity());
		entityManager.merge(item);
		return (cartItem.getGroceryItemQuantity()*item.getGroceryItemPrize());
	}

}
