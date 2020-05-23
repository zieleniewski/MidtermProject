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

class EventTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Event event;

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
		event = em.find(Event.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		event = null;
		em.close();
	}

	@Test
	@DisplayName("testing event mapping")
	void test1() {
		assertNotNull(event);
		assertEquals("TestFest", event.getTitle());
		assertEquals("someimage.png", event.getImgURL());
	}
	
	@Test
	@DisplayName("testing relational mapping to User")
	void test2() {
		assertNotNull(event.getOrganizer());
		assertEquals("admin", event.getOrganizer().getUsername());
		assertEquals("admin", event.getOrganizer().getPassword());
	}

	@Test
	@DisplayName("testing relational mapping to Address")
	void test3() {
		assertNotNull(event.getAddress());
		assertEquals("Adminsville", event.getAddress().getCity());
		assertEquals("Adminado", event.getAddress().getState());
	}
	
	@Test
	@DisplayName("testing relational mapping to EventGame")
	void test4() {
		assertNotNull(event.getEventGames());
		assertTrue(event.getEventGames().size() > 0);
		assertEquals("Just a buncha nerds nerdin'", event.getEventGames().get(0).getDescription());
		assertEquals(2, event.getEventGames().get(0).getMinPlayers());
		assertEquals(2, event.getEventGames().get(0).getMaxPlayers());
	}
	
	@Test
	@DisplayName("testing relational mapping to EventComment")
	void test5() {
		assertNotNull(event.getEventComments());
		assertTrue(event.getEventComments().size() > 0);
		assertEquals("Incredible event. Holy smokes.", event.getEventComments().get(0).getComment());
	}
	
	@Test
	@DisplayName("testing EventGames Attendees")
	void test6() {
		assertNotNull(event.getEventGames().get(0).getPlayers());
		assertTrue(event.getEventGames().get(0).getPlayers().size() > 0);
		assertEquals("admin test", event.getEventGames().get(0).getPlayers().get(0).getAttendeeComment());
	}
	
	@Test
	@DisplayName("testing mapping through Attendee to User")
	void test7() {
		assertNotNull(event.getEventGames().get(0).getPlayers().get(0).getUser());
		assertEquals("admin", event.getEventGames().get(0).getPlayers().get(0).getUser().getUsername());
	}
}
