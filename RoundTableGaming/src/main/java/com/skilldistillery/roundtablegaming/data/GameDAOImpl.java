package com.skilldistillery.roundtablegaming.data;

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
		String query= "SELECT g FROM Game g WHERE g.title LIKE '"+"%"+keyword+"%'";
		List<Game> foundGames = em.createQuery(query, Game.class)
				.getResultList();
		return foundGames;
	}

	@Override
	public Game getGameByTitle(String title) {
		String query = "SELECT g FROM Game g WHERE g.title = :title";
		Game game = em.createQuery(query, Game.class)
				.setParameter("title", title)
				.getSingleResult();
		return game;
	}
	
	@Override
	public List<Game> getGamesByCategory(int categoryID) {
		String query = "SELECT g FROM Game g WHERE g.category = :catId";
		List<Game> games = em.createQuery(query, Game.class)
				.setParameter("catId", categoryID)
				.getResultList();
		return games;
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
	
	@Override
	public boolean enableGame(int id) {
		Game game = em.find(Game.class, id);
		if (game != null) {
			game.setEnabled(true);
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public boolean disableGame(int id) {
		Game game = em.find(Game.class, id);
		if (game != null) {
			game.setEnabled(false);
			return true;
		}
		else {
			return false;
		}
	}
	
}
