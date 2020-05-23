package com.skilldistillery.roundtablegaming.data;

import java.util.List;

import com.skilldistillery.roundtablegaming.entities.Game;

public interface GameDAO {
	
	public Game createGame(Game game);
	public List<Game> getAllGames();
	public Game updateGame(Game game);
	public boolean deleteGame(int id);
	//For Listing Games by Category
	public List<Game> findGamesByCategory(int categoryID);
	//For Listing Games by Search
	public List<Game> findGamesByKeyword(String keyword);
	//Possibly used internally
	public Game findGameById(int id);
	
}
