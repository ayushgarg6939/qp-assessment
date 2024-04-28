package com.grocery.viewCart.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "grocery_cart_history")
@IdClass(GroceryCartHistoryPrimaryKey.class)
public class GroceryCartHistory {
	
	@Id
	@Column(name = "grocery_user_Id")
	private String groceryUserId;
	
	@Id
	@Column(name = "grocery_item_name")
	private String groceryItemName;
	
	@Column(name = "grocery_item_quantity")
	private int groceryItemQuantity;
	
	@Column(name = "grocery_item_img_url")
	private String groceryItemUrl;
	
	@Column(name = "gorcery_item_price")
	private double groceryItemPrice; 
}
