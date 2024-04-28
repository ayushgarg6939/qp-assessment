package com.grocery.bookItem.controller;

import org.springframework.http.ResponseEntity;

import com.grocery.bookItem.model.ResponceModel;

public interface BookItemsController {

	ResponseEntity<ResponceModel> completeBooking(String userId);
}
