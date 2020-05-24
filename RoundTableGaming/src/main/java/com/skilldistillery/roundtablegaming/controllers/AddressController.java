package com.skilldistillery.roundtablegaming.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.roundtablegaming.data.AddressDAO;
import com.skilldistillery.roundtablegaming.entities.Event;

@Controller
public class AddressController {
	
	@Autowired
	private AddressDAO dao;

	@RequestMapping(path = "zipsearch.do", method = RequestMethod.POST)
	public String searchByZipCode(@RequestParam String zipCode, HttpSession session) {
		List<Event> zipResults = dao.searchByZipCode(zipCode);
		System.out.println(zipResults.get(0).toString());
		session.setAttribute("events", zipResults);
		return "#";
	}
}
