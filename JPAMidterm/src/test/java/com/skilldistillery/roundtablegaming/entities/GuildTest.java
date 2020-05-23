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

class GuildTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Guild guild;

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
		guild = em.find(Guild.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		guild = null;
		em.close();
	}

	@Test
	@DisplayName("testing Guild mapping")
	void test1() {
		assertNotNull(guild);
		assertEquals("Guild of Mecha Admins", guild.getName());
		assertEquals("DBA Life", guild.getDescription());
		assertEquals("anon.jpg", guild.getLogoURL());
	}
	
//	@Test
//	@DisplayName("testing relational mapping to User")
//	void test2() {
//		assertNotNull(guild.getMembers());
//		assertTrue(guild.getMembers().size() > 0);
//		assertEquals("")
//	}

}
