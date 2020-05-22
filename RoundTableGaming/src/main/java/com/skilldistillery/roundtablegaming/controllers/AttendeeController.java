package com.skilldistillery.roundtablegaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class AttendeeController {

	@Autowired
	private AttendeeDAO dao;
}
