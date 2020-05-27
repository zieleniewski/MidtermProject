package com.skilldistillery.roundtablegaming.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.skilldistillery.roundtablegaming.data.GameDAO;
import com.skilldistillery.roundtablegaming.entities.Game;

@Controller
public class GameController {

	@Autowired
	private GameDAO dao;
	
	@GetMapping("searchByGame.do")
	public String sbg(@RequestParam String keyword, Model model) {
		List<Game> searchedGames = dao.getGamesByKeyword(keyword);
		model.addAttribute("searchedGames", searchedGames);
		return "searchedEvents";
	}
}
