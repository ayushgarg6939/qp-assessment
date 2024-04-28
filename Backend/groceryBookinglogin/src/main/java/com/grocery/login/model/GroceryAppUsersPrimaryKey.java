package com.grocery.login.model;

import java.io.Serializable;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GroceryAppUsersPrimaryKey implements Serializable{
	

	private static final long serialVersionUID = 1L;
	private String groceryAppUserName;
	private String groceryAppUserPassword;
}
