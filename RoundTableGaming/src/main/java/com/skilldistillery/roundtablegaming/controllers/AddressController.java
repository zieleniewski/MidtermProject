package com.skilldistillery.roundtablegaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.roundtablegaming.data.AddressDAO;

@Controller
public class AddressController {
	
	@Autowired
	private AddressDAO dao;

	
}
