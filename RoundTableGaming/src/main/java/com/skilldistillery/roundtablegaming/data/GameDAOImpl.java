package com.skilldistillery.roundtablegaming.data;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.skilldistillery.roundtablegaming.entities.Game;

@Service
@Transactional
public class GameDAOImpl implements GameDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Game createGame(Game game) {
		em.persist(game);
		em.flush();
		return game;
	}

	@Override
	public List<Game> getAllGames() {

		String query= "SELECT g FROM Game g";
		List<Game> allGames = em.createQuery(query, Game.class).getResultList();

		return allGames;
	}
		
	@Override
	public Game getGameById(int id) {
		return em.find(Game.class, id);
	}
	
	@Override
	public List<Game> getGamesByKeyword(String keyword) {
		
//		String newKeyword= "'%"+keyword+"%'";
		String query= "SELECT g FROM Game g WHERE g.title LIKE '" + "%" + keyword + "%'";
		List<Game> foundGames = em.createQuery(query, Game.class).getResultList();
		
		return foundGames;
	}
	
	@Override
	public List<Game> getGamesByCategory(int categoryID) {
		List<Game> allGames= getAllGames();
		List<Game> categoryGames= new ArrayList<>();
		
		for (Game game : allGames) {
			if(game.getCategory().getId() == categoryID ) {
				categoryGames.add(game);
			}
		}
		return categoryGames;
	}
	
	@Override
	public Game updateGame(Game game) {
		Game updated = em.find(Game.class, game.getId());
		
		if (updated != null) {
			updated.setTitle(game.getTitle());
			updated.setDescription(game.getDescription());
			updated.setMinPlayers(game.getMinPlayers());
			updated.setMaxPlayers(game.getMaxPlayers());
			updated.setEnabled(game.isEnabled());
			em.persist(updated);
			em.flush();
		}
		return updated;
	}
	
	public boolean deleteGame(int id) {
		
		boolean deleted = false;
		Game toRemove = em.find(Game.class, id);
		
		if(toRemove != null) {
			em.remove(toRemove);
			deleted= true;
		}
		return deleted;
	}

}
