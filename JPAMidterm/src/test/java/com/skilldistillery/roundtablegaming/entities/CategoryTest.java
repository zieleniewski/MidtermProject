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

class CategoryTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Category cat;

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
		cat = em.find(Category.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		cat = null;
		em.close();
	}

	@Test
	@DisplayName("testing category mapping")
	void test1() {
		assertNotNull(cat);
		assertEquals("Tabletop RPG", cat.getName());
		assertEquals("A form of role-playing game (RPG) in which the participants "
				+ "describe their characters' actions through speech. Participants "
				+ "determine the actions of their characters based on their characterization, "
				+ "and the actions succeed or fail according to a set formal system "
				+ "of rules and guidelines. Within the rules, players have the freedom "
				+ "to improvise; their choices shape the direction and "
				+ "outcome of the game.", cat.getDescription());
	}

}
