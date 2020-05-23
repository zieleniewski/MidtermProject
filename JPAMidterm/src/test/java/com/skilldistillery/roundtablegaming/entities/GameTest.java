package com.skilldistillery.roundtablegaming.entities;

import static org.junit.jupiter.api.Assertions.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Game game;

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		emf = Persistence.createEntityManagerFactory("RoundTable");
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
		emf.close();
	}

	@BeforeEach
	void setUp() throws Exception {
		em = emf.createEntityManager();
		game = em.find(Game.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		game = null;
		em.close();
	}

	@Test
	@DisplayName("testing Game mapping")
	void test1() {
		assertNotNull(game);
		assertEquals("Blades In The Dark", game.getTitle());
		assertEquals(10, game.getMaxPlayers());
		assertEquals(3, game.getMinPlayers());
		assertTrue(game.isEnabled());
	}

	@Test
	@DisplayName("testing relational mapping to Category")
	void test2() {
		assertNotNull(game.getCategory());
		assertEquals("Tabletop RPG", game.getCategory().getName());
		assertEquals("A form of role-playing game (RPG) in which the participants "
				+ "describe their characters' actions through speech. Participants "
				+ "determine the actions of their characters based on their characterization, "
				+ "and the actions succeed or fail according to a set formal system "
				+ "of rules and guidelines. Within the rules, players have the freedom "
				+ "to improvise; their choices shape the direction "
				+ "and outcome of the game.", game.getCategory().getDescription());
	}
	
	@Test
	@DisplayName("testing relational mapping to EventGame")
	void test3() {
		assertNotNull(game.getEventGames());
		assertTrue(game.getEventGames().size() > 0);
		assertEquals("Just a buncha nerds nerdin'", game.getEventGames().get(0).getDescription());
		assertEquals(2, game.getEventGames().get(0).getMinPlayers());
		assertEquals(2, game.getEventGames().get(0).getMaxPlayers());
	}
	
	@Test
	@DisplayName("testing relational mapping to User")
	void test4() {
		assertNotNull(game.getCreator());
		assertEquals("admin", game.getCreator().getUsername());
		assertEquals("admin", game.getCreator().getPassword());
	}
	
}
