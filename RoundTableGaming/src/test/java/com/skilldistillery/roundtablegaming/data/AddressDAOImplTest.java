package com.skilldistillery.roundtablegaming.data;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.skilldistillery.roundtablegaming.entities.Address;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class AddressDAOImplTest {
	
	@Autowired
	AddressDAOImpl daoImpl;

	@Test
	@DisplayName("testing getAddressesForAllEvents")
	void test1() {
		Address a = new Address();
		a.setId(1);
		List<Address> addresses = daoImpl.getAddressesForAllEvents();
		assertNotNull(addresses);
		assertTrue(addresses.size() > 0);
		assertEquals("Adminsville", addresses.get(0).getCity());
	}

}
