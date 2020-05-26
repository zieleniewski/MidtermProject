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

import com.skilldistillery.roundtablegaming.entities.Attendee;
import com.skilldistillery.roundtablegaming.entities.Event;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
class EventDAOImplTest {
	
	@Autowired
	EventDAOImpl daoImpl;

	@Test
	@DisplayName("testing getAllAttendees")
	void test1() {
		Event e = new Event();
		e.setId(1);
		List<Attendee> attendees = daoImpl.getEventAttendees(e);
		assertNotNull(attendees);
		assertTrue(attendees.size() > 0);
		assertEquals("admin", attendees.get(0).getUser().getUsername());
	}

}
