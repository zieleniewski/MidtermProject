package com.skilldistillery.roundtablegaming.controllers;

import java.time.LocalDateTime;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.roundtablegaming.data.AddressDAO;
import com.skilldistillery.roundtablegaming.data.UserDAO;
import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.User;

@Controller
public class UserController {

	@Autowired
	private UserDAO dao;
	
	@Autowired
	private AddressDAO addrDao;

	@RequestMapping(path = "registrationComplete.do", method = RequestMethod.POST)
	public String completeUser(User user, Address address, HttpSession session) {
		user.setCreated(LocalDateTime.now());
		User newUser = dao.createUser(user, address);
		session.setAttribute("loggedInUser", newUser);
		return "index";
	}

	@RequestMapping(path = "logIn.do")
	public String login(User user, HttpSession session) {
		User loggingUser = dao.checkLogin(user);
		if (loggingUser == null || !loggingUser.isEnabled()) {
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
		Address updatedAddress = addrDao.checkAddress(address);
		User updatedUser = dao.updateAccount(user, updatedAddress);
		session.setAttribute("loggedInUser", updatedUser);
		return "account";
	}
	
	@PostMapping("updateUsername.do")
	public String updateUsername(User user, HttpSession session) {
		User updatedUser = dao.updateUsername(user);
		session.setAttribute("loggedInUser", updatedUser);
		return "account";
	}

	@PostMapping("updatePassword.do")
	public String updatePassword(@RequestParam String currentPassword, String newPassword, String verifyPassword,
			User user, HttpSession session, Model model) {
		if (currentPassword.equals(user.getPassword())) {
			if (newPassword.equals(verifyPassword)) {
				user.setPassword(verifyPassword);
				User newPasswordUser = dao.updatePassword(user);
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
	
	@PostMapping("deleteAccount.do")
	public String deleteAccount(HttpSession session) {
		User disabled = (User)session.getAttribute("loggedInUser");
		dao.disableUser(disabled.getId());
		session.removeAttribute("loggedInUser");
		return "index";
	}
}
