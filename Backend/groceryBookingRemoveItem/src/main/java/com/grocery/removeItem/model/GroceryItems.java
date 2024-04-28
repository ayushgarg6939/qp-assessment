package com.grocery.removeItem.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "grocery_items")
public class GroceryItems {

	@Id
	@Column(name = "grocery_item_name")
	private String groceryItemName;
	
	@Column(name = "grocery_item_inventory_size")
	private int groceryItemInventorySize;
	
	@Column(name = "grocery_item_price")
	private double groceryItemPrize;
	
	@Column(name = "image_url")
	private String imgUrl;
	
}
