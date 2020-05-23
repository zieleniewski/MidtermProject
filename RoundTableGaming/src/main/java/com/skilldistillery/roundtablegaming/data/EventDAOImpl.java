package com.skilldistillery.roundtablegaming.data;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.Category;
import com.skilldistillery.roundtablegaming.entities.Event;
import com.skilldistillery.roundtablegaming.entities.Game;

@Service
@Transactional
public class EventDAOImpl implements EventDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Event createEvent(Event event) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getAllEvents() {
		String query= "SELECT e FROM Event e";
		List<Event> allEvents = em.createQuery(query, Event.class).getResultList();
		return allEvents;
	}

	@Override
	public Event getEventById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventsByAddress(Address address) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventsByCategory(Category category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventsByGame(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventsByDate(LocalDateTime when) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Event> getEventsByKeyword(String keyword) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Event updateEvent(Event event, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEvent(int id) {
		// TODO Auto-generated method stub
		return false;
	}

}
