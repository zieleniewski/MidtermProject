package com.skilldistillery.roundtablegaming.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.roundtablegaming.data.EventCommentDAO;
import com.skilldistillery.roundtablegaming.data.EventDAO;
import com.skilldistillery.roundtablegaming.entities.Event;
import com.skilldistillery.roundtablegaming.entities.EventComment;
import com.skilldistillery.roundtablegaming.entities.User;

@Controller
public class EventCommentController {

	@Autowired
	EventCommentDAO dao;
	
	@Autowired
	EventDAO eventDao;

	@PostMapping("postComment.do")
	public String postComment(@RequestParam Integer evId, EventComment ec, HttpSession session, Model model) {
		Event event = eventDao.getEventById(evId);
		ec.setEvent(event);
		System.out.println();
		ec.setUser((User) session.getAttribute("loggedInUser"));
		dao.createEventComment(ec);
		model.addAttribute("comment", ec);
		return "redirect:singleEvent.do?id=" + evId;
	}
	
	@PostMapping("updateComment.do")
	public String updateComment(EventComment ec, Model model) {
		dao.updateEventComment(ec);
		model.addAttribute("updComment", ec);
		return "thisEvent";
	}
	
	@GetMapping("getAllComments.do")
	public String getAllComments(Model model) {
		List<EventComment> allComments = dao.getAllEventComments();
		model.addAttribute("allComments", allComments);
		return "thisEvent";
	}
	
	@GetMapping("getThisEventComments.do")
	public String getThisComments(@RequestParam Integer evId, Model model) {
		List<EventComment> thisComments = dao.getEventCommentsByEventId(evId);
		model.addAttribute("thisComments", thisComments);
		return "thisEvent";
	}
	
	@GetMapping("getSingleComment.do")
	public String account(@RequestParam Integer comId, Model model) {
		EventComment ec = dao.getEventCommentById(comId);
		model.addAttribute("comment", ec);
		return "thisEvent";
	}

}