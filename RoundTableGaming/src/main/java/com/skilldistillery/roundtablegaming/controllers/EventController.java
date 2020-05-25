package com.skilldistillery.roundtablegaming.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.roundtablegaming.data.EventDAO;
import com.skilldistillery.roundtablegaming.data.GameDAO;
import com.skilldistillery.roundtablegaming.entities.Attendee;
import com.skilldistillery.roundtablegaming.entities.Event;
import com.skilldistillery.roundtablegaming.entities.Game;

@Controller
public class EventController {
	
	@Autowired
	private EventDAO dao;
	
	@Autowired
	private GameDAO gameDao;

	@GetMapping("rpg.do")
	public String rpg(Model model) {
		List<Event> rpgEvents = dao.getEventsByCategory("Tabletop RPG");
		model.addAttribute("category", rpgEvents);
		return "rpg";
	}
	
	@GetMapping("miniature.do")
	public String mini(Model model) {
		List<Event> miniEvents = dao.getEventsByCategory("Miniatures");
		model.addAttribute("category", miniEvents);
		return "miniature";
	}
	
	@GetMapping("tcg.do")
	public String tcg(Model model) {
		List<Event> tcgEvents = dao.getEventsByCategory("Trading Card Games");
		model.addAttribute("category", tcgEvents);
		return "tcg";
	}
	
	@GetMapping("searchByGame.do")
	public String sbg(@RequestParam String keyword, Model model) {
		List<Game> searchedGames = gameDao.getGamesByKeyword(keyword);
		model.addAttribute("searchedGames", searchedGames);
		return "searchedGames";
	}
	
	@GetMapping("getAttendees.do")
	public String getAttendees(int eventId, Model model) {
		Event event = dao.getEventById(eventId);
		List<Attendee> unfiltAttendees = dao.getEventAttendees(event);
		List<Attendee> attendees = dao.filterUniqueAttendees(unfiltAttendees);
		model.addAttribute("attendees", attendees);
		return "events";
	}
	
	@GetMapping("createEventPage.do")
	public String createEvent(Model model) {
		List<Game> allGames = gameDao.getAllGames();
		model.addAttribute("games", allGames);
		return "createEvent";
	}
	
	@PostMapping("searchByDate.do")
	public String getEventsByDate(@RequestParam 
			@DateTimeFormat(iso = ISO.DATE) LocalDate date, HttpSession session) {
		List<Event> dateResults = dao.getEventsByDate(date);
		System.out.println(dateResults.get(0).toString());
		session.setAttribute("events", dateResults);
		return "#";
	}
	
	@PostMapping("createEvent.do")
	public String create(Event newEvent, Model model) {
		Event event = dao.createEvent(newEvent);
		model.addAttribute("newEvent", event);
		return "account";
	}
	
}
