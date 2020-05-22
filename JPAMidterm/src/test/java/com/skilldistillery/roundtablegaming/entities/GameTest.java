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
	@DisplayName("testing user mapping")
	void test1() {
		assertNotNull(game);
		//assertEquals("Blades in the Dark is a tabletop role-playing game about a crew of daring scoundrels seeking their fortunes on the haunted streets of an industrial-fantasy city. There are heists, chases, occult mysteries, dangerous bargains, bloody skirmishes, and, above all, riches to be had — if you’re bold enough to seize them.\n" + 
		//		"You and your fledgling crew must thrive amidst the threats of rival gangs, powerful noble families, vengeful ghosts, the Bluecoats of the city watch, and the siren song of your scoundrel’s own vices. Will you rise to power in the criminal underworld? What are you willing to do to get to the top?", game.getDescription());
		assertEquals("Blades In The Dark", game.getTitle());
		assertEquals(10, game.getMaxPlayers());
		assertEquals(3, game.getMinPlayers());
		assertTrue(game.isEnabled());
	}

}
