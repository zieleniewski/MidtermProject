package com.skilldistillery.roundtablegaming.controllers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.skilldistillery.roundtablegaming.data.EventDAO;
import com.skilldistillery.roundtablegaming.data.UserDAO;
import com.skilldistillery.roundtablegaming.entities.Attendee;
import com.skilldistillery.roundtablegaming.entities.Event;
import com.skilldistillery.roundtablegaming.entities.User;

@Controller
public class HomeController {
	
	@Autowired
	private UserDAO userDao;
	
	@Autowired
	private EventDAO eventDao;

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
		User loggedInUser = (User) session.getAttribute("loggedInUser");
		loggedInUser = userDao.getUserById(loggedInUser.getId());
		session.setAttribute("loggedInUser", loggedInUser);
		try {
			List<Attendee> attendees = loggedInUser.getAttendees();
			List<Event> orgEvents = eventDao.getEventsByOrganizerId(loggedInUser.getId());
			List<Event> allEvents = new ArrayList<>();
			List<Event> pastEvents = new ArrayList<>();
			List<Event> futureEvents = new ArrayList<>();

			if (attendees != null) {
				for (Attendee attendee : attendees) {
					allEvents.add(attendee.getEventGame().getEvent());
				}
			}
			
			for (Event event : allEvents) {
				if (LocalDate.now().isAfter(event.getEventDate())) {
					pastEvents.add(event);
				} else {
					futureEvents.add(event);
				}
			}

			model.addAttribute("orgEvents", orgEvents);
			model.addAttribute("pastEvents", pastEvents);
			model.addAttribute("futureEvents", futureEvents);
		} catch (Exception e) {
			System.out.println("\nUSER HAS NO EVENTS ASSOCIATED WITH THEM\n");
			e.printStackTrace();
		}
		return "account";
	}

	@GetMapping("about.do")
	public String about() {
		return "about-us";
	}
	
}
