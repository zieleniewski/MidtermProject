package com.skilldistillery.roundtablegaming.controllers;

import java.time.LocalDate;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.format.annotation.DateTimeFormat.ISO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.roundtablegaming.data.EventDAO;
import com.skilldistillery.roundtablegaming.entities.Event;

@Controller
public class EventController {
	
	@Autowired
	private EventDAO dao;

	@RequestMapping(path = "searchByDate.do", method = RequestMethod.POST)
	public String getEventsByDate(@RequestParam 
			@DateTimeFormat(iso = ISO.DATE) LocalDate date, HttpSession session) {
		List<Event> dateResults = dao.getEventsByDate(date);
		System.out.println(dateResults.get(0).toString());
		session.setAttribute("events", dateResults);
		return "#";
	}
}
