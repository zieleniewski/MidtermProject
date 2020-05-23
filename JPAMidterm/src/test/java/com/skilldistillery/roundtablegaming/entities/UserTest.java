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

class UserTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private User user;

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
		user = em.find(User.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		user = null;
		em.close();
	}

	@Test
	@DisplayName("testing User mapping")
	void test1() {
		assertNotNull(user);
		assertEquals("admin", user.getUsername());
		assertEquals("admin", user.getPassword());
		assertTrue(user.isEnabled());
	}
	
	@Test
	@DisplayName("testing relational mapping to Game")
	void test2() {
		assertNotNull(user.getGames());
		assertTrue(user.getGames().size() > 0);
		assertEquals("Blades In The Dark", user.getGames().get(0).getTitle());
		assertEquals(3, user.getGames().get(0).getMinPlayers());
		assertEquals(10, user.getGames().get(0).getMaxPlayers());
	}
	@Test
	@DisplayName("testing relational mapping to Address")
	void test3() {
		assertNotNull(user.getAddress());
		assertEquals("Adminsville", user.getAddress().getCity());
		assertEquals("Adminado", user.getAddress().getState());
	}
	@Test
	@DisplayName("testing relational mapping to Attendee")
	void test4() {
		assertNotNull(user.getAttendees());
		assertTrue(user.getAttendees().size() > 0);
		assertEquals("admin test", user.getAttendees().get(0).getAttendeeComment());
		assertEquals(5, user.getAttendees().get(0).getEventRating());
	}
	@Test
	@DisplayName("testing relational mapping to Event")
	void test5() {
		assertNotNull(user.getEvents());
		assertTrue(user.getEvents().size() > 0);
		assertEquals("TestFest", user.getEvents().get(0).getTitle());
		assertEquals("Just some sweet admin testing", user.getEvents().get(0).getDescription());
	}
	@Test
	@DisplayName("testing relational mapping to EventComment")
	void test6() {
		assertNotNull(user.getComments());
		assertTrue(user.getComments().size() > 0);
		assertEquals("Incredible event. Holy smokes.", user.getComments().get(0).getComment());
	}
	@Test
	@DisplayName("testing relational mapping to Guild")
	void test7() {
		assertNotNull(user.getGuilds());
		assertTrue(user.getGuilds().size() > 0);
		assertEquals("Guild of Mecha Admins", user.getGuilds().get(0).getName());
		assertEquals("DBA Life", user.getGuilds().get(0).getDescription());
	}

}
