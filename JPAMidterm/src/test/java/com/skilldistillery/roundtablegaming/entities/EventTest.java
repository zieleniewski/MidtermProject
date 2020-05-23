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
	private EventComment evCom;

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
		evCom = em.find(EventComment.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		evCom = null;
		em.close();
	}

	@Test
	@DisplayName("testing event mapping")
	void test1() {
		assertNotNull(evCom);
		assertEquals("2020-05-22T17:14", evCom.getCommentDate().toString());
		assertEquals("Incredible event. Holy smokes.", evCom.getComment());
	}

}
