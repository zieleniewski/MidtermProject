package com.skilldistillery.roundtablegaming.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.skilldistillery.roundtablegaming.data.GameDAO;

@Controller
public class GameController {

	@Autowired
	private GameDAO dao;
	
	
}
