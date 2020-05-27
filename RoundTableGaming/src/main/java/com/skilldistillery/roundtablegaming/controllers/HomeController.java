package com.skilldistillery.roundtablegaming.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.roundtablegaming.entities.Attendee;
import com.skilldistillery.roundtablegaming.entities.Event;
import com.skilldistillery.roundtablegaming.entities.User;

@Controller
public class HomeController {

	@RequestMapping(path = { "/", "home.do" })
	public String home() {
		return "index";
	}

	@GetMapping("register.do")
	public String register() {
		return "register";
	}
	
	@GetMapping("account.do")
	public String account(HttpSession session, Model model) {
		User loggedInUser = (User)session.getAttribute("loggedInUser");
		List<Attendee> attendees = loggedInUser.getAttendees();
		List<Event> allEvents = new ArrayList<>();
		List<Event> pastEvents = new ArrayList<>();
		List<Event> futureEvents = new ArrayList<>();
		
		for (Attendee attendee : attendees) {
			allEvents.add(attendee.getEventGame().getEvent());
		}
		
		for (Event event : allEvents) {
			if (LocalDate.now().isAfter(event.getEventDate())) {
				pastEvents.add(event);
			}
			else {
				futureEvents.add(event);
			}
		}
		
		model.addAttribute("pastEvents", pastEvents);
		model.addAttribute("futureEvents", futureEvents);
		return "account";
	}
	
}
