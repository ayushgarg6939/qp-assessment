package com.grocery.viewCart.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class GroceryCartHistoryPrimaryKey implements Serializable{

	private static final long serialVersionUID = 1L;
	private String groceryUserId;
	private String groceryItemName;
}
