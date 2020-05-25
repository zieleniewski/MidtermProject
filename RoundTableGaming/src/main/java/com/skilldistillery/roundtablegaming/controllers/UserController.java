package com.skilldistillery.roundtablegaming.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.roundtablegaming.data.UserDAO;
import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO dao;

	@RequestMapping(path = "registrationComplete.do", method = RequestMethod.POST)
	public String completeUser(User user, Address address, HttpSession session) {
		User newUser = dao.createUser(user, address);
		session.setAttribute("loggedInUser", newUser);
		return "index";
	}

	@RequestMapping(path = "logIn.do")
	public String login(User user, HttpSession session) {
		User loggingUser = dao.checkLogin(user);
		if (loggingUser == null) {
			return "index";
		} else {
			session.setAttribute("loggedInUser", loggingUser);
			return "redirect:home.do";
		}
	}

	@RequestMapping(path = "logOut.do")
	public String logOut(HttpSession session) {
		session.removeAttribute("loggedInUser");
		return "index";
	}

	@PostMapping("updateAccount.do")
	public String updateAccount(User user, Address address, HttpSession session) {
		User updatedUser = dao.updateUser(user);
		session.setAttribute("loggedInUser", updatedUser);
		return "index";
	}

	@PostMapping("updatePassword.do")
	public String updatePassword(@RequestParam String currentPassword, String newPassword, String verifyPassword,
			User user, HttpSession session, Model model) {
		if (currentPassword.equals(user.getPassword())) {
			if (newPassword.equals(verifyPassword)) {
				user.setPassword(verifyPassword);
				User newPasswordUser = dao.updateUser(user);
				session.setAttribute("loggedInUser", newPasswordUser);
				return "account";
			} else {
				boolean correctPassword = false;
				model.addAttribute("correctPassword", correctPassword);
				return "account";
			}
		} else {
			boolean correctPassword = false;
			model.addAttribute("correctPassword", correctPassword);
			return "account";

		}
	}
}
