package com.grocery.bookItem.service;

import java.util.List;
import org.hibernate.HibernateException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import com.grocery.bookItem.model.GroceryCartHistory;
import com.grocery.bookItem.repository.ConfirmBookingRepo;

@Service
public class ConfirmBookingServiceImpl implements ConfirmBookingService{

	private ConfirmBookingRepo confirmBookingRepo;
	
	public ConfirmBookingServiceImpl(ConfirmBookingRepo confirmBookingRepo) {
		this.confirmBookingRepo = confirmBookingRepo;
	}
	
	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public List<GroceryCartHistory> fetchCartDetails(String userId) {
		
		return confirmBookingRepo.fetchCartDetails(userId);
	}

	@Override
	@Transactional(isolation = Isolation.READ_COMMITTED)
	public double confirmBooking(List<GroceryCartHistory> cartItemsList) {
		double totalPrice = 0;
		for(GroceryCartHistory cartItem : cartItemsList) {
			try {
				double price = confirmBookingRepo.confirmBooking(cartItem);
				totalPrice = totalPrice+price;
			}catch(HibernateException hbException) {
				//log the item name that could not be booked.
			}
			
		}
		
		return totalPrice;
	}
	

}
