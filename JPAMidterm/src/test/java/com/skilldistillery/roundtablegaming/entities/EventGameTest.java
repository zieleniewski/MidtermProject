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

class EventGameTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private EventGame evGame;

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
		evGame = em.find(EventGame.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		evGame = null;
		em.close();
	}

	@Test
	@DisplayName("testing EventGame mapping")
	void test1() {
		assertNotNull(evGame);
		assertEquals("Just a buncha nerds nerdin'", evGame.getDescription());
		assertEquals(2, evGame.getMinPlayers());
		assertEquals(2, evGame.getMaxPlayers());
	}
	
	@Test
	@DisplayName("testing relational mapping to Game")
	void test2() {
		assertNotNull(evGame.getGame());
		assertEquals("Blades In The Dark", evGame.getGame().getTitle());
		assertEquals(3, evGame.getGame().getMinPlayers());
		assertEquals(10, evGame.getGame().getMaxPlayers());
	}
	
	@Test
	@DisplayName("testing relational mapping to Attendee")
	void test3() {
		assertNotNull(evGame.getPlayers());
		assertTrue(evGame.getPlayers().size() > 0);
		assertEquals("Incredible event. Holy smokes.", evGame.getPlayers().get(0).getAttendeeComment());
	}

	@Test
	@DisplayName("testing relational mapping to Event")
	void test4() {
		assertNotNull(evGame.getEvent());
		assertEquals("TestFest", evGame.getEvent().getTitle());
		assertEquals("someimage.png", evGame.getEvent().getImgURL());
	}
}
