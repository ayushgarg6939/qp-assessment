package com.grocery.orderHistory.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "grocery_booking_history")
@IdClass(GroceryBookingHistoryPrimaryKey.class)
public class GroceryBookingHistory {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "grocery_booking_id")
	private int groceryBookingId;
	
	@Id
	@Column(name = "grocery_user_Id")
	private String groceryUserId;
	
	@Id
	@Column(name = "grocery_item_name")
	private String groceryItemName;
	
	@Column(name = "grocery_item_quantity")
	private int groceryItemQuantity;
	
	@Column(name = "grocery_item_price")
	private double groceryItemPrice;
	
	@Column(name = "grocery_booking_date")
	private LocalDate groceryBookingDate;
	
	@Column(name = "grocery_img_url")
	private String groceryImageUrl;
}
