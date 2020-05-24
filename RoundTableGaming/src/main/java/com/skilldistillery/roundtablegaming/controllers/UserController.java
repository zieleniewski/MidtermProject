package com.skilldistillery.roundtablegaming.controllers;



import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.skilldistillery.roundtablegaming.data.UserDAO;
import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO dao;
	
	
	@RequestMapping(path = "registrationComplete.do", method = RequestMethod.POST)
	public String completeUser(User user, Address address, Model model, HttpSession session) {
		User newUser = dao.createUser(user, address);
		session.setAttribute("user", newUser);
		return "index";
	}
	
	@RequestMapping(path = "logIn.do")
	public String login(User user, HttpSession session) {
		User loggingUser = dao.checkLogin(user);
		System.out.println(loggingUser);
			session.setAttribute("loggedInUser", loggingUser);
			return "index";
		
	}
}
