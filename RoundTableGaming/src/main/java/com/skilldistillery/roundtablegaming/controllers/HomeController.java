package com.skilldistillery.roundtablegaming.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

	@RequestMapping(path= {"/","home.do"})
	public String home() {
		
		return "index";
	}
	
	@GetMapping("register.do")
	public String register() {
		return "register";
	}
	
}
