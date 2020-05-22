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

class AddressTest {
	private static EntityManagerFactory emf;
	private EntityManager em;
	private Address addr;

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
		addr = em.find(Address.class, 1);
	}

	@AfterEach
	void tearDown() throws Exception {
		addr = null;
		em.close();
	}

	@Test
	@DisplayName("testing address mapping")
	void test1() {
		assertNotNull(addr);
		assertEquals("123 admin st", addr.getStreet1());
		assertEquals("Adminsville", addr.getCity());
		assertEquals("Adminado", addr.getState());
		assertEquals("00000", addr.getZipCode());
	}

}
