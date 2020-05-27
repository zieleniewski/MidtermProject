package com.skilldistillery.roundtablegaming.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.skilldistillery.roundtablegaming.data.AttendeeDAO;
import com.skilldistillery.roundtablegaming.entities.Attendee;
import com.skilldistillery.roundtablegaming.entities.AttendeeId;
import com.skilldistillery.roundtablegaming.entities.User;

@Controller
public class AttendeeController {

	@Autowired
	private AttendeeDAO dao;
	
	@PostMapping("joinEvent.do")
	public String joinEvent(HttpSession session, int egId, Model model) {
		User loggedInUser = (User)session.getAttribute("loggedInUser");
		if (loggedInUser != null) {
			Attendee atten = dao.create(loggedInUser, egId);
			model.addAttribute("attendee", atten);
		}
		else {
			return "index";
		}
		return "redirect:thisEvent";
	}
	
	@PostMapping("leaveEvent.do")
	public String leaveEvent(HttpSession session, AttendeeId attendeeId,
			Model model) {
		String left = "";
		boolean disabled = dao.disable(attendeeId);
		if (disabled) {
			left = "You left this event";
		}
		else {
			left = "Error leaving this event";
		}
		model.addAttribute("left", left);
		return "redirect:account";
	}
}
