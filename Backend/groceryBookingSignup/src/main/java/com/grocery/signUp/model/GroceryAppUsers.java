package com.grocery.signUp.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
@Table(name = "grocery_app_users")
@IdClass(GroceryAppUsersPrimaryKey.class)
public class GroceryAppUsers {

	@Id
	@Column(name = "grocery_app_user_name")
	private String groceryAppUserName;
	
	@Id
	@Column(name = "grocery_app_user_password")
	private String groceryAppUserPassword;
	
	@Column(name = "grocery_app_user_role")
	private String groceryAppUserRole;
	
	@Column(name = "grocery_app_user_Id")
	private String groceryAppUserId;
}
