package com.skilldistillery.roundtablegaming.data;

import java.util.List;

import com.skilldistillery.roundtablegaming.entities.Game;

public interface GameDAO {
	
	public Game createGame(Game game);
	
	public List<Game> getAllGames();
	
	public Game updateGame(Game game);
	
	public boolean enableGame(int id);
	
	public boolean disableGame(int id);
	
	public Game getGameByTitle(String title);
	
	public List<Game> getGamesByCategory(int categoryID);
	
	public List<Game> getGamesByKeyword(String keyword);
	
	public Game getGameById(int id);
	
}
