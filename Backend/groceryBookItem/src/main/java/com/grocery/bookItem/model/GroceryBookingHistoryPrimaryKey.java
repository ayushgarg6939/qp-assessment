package com.grocery.bookItem.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GroceryBookingHistoryPrimaryKey implements Serializable{

	private static final long serialVersionUID = 1L;
	private int groceryBookingId;
	private String groceryUserId;
	private String groceryItemName;
}
