package com.skilldistillery.roundtablegaming.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.Category;
import com.skilldistillery.roundtablegaming.entities.Event;
import com.skilldistillery.roundtablegaming.entities.EventGame;
import com.skilldistillery.roundtablegaming.entities.Game;

@Service
@Transactional
public class EventDAOImpl implements EventDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Event createEvent(Event event) {
		em.persist(event);
		em.flush();
		return event;
	}

	@Override
	public List<Event> getAllEvents() {
		String query = "SELECT e FROM Event e";
		List<Event> allEvents = em.createQuery(query, Event.class).getResultList();
		return allEvents;
	}

	@Override
	public Event getEventById(int id) {
		return em.find(Event.class, id);
	}

	@Override
	public List<Event> getEventsByAddress(Address address) {
		List<Event> events = getAllEvents();
		for (Event event : events) {
			if (event.getAddress().equals(address))
				events.add(event);
		}
		return events;
	}

	@Override
	public List<Event> getEventsByCategory(Category category) {
		List<Event> allEvents = getAllEvents();
		List<Event> selectedEvents = new ArrayList<>();
		for (Event event : allEvents) {
			List<EventGame> eventGames = event.getEventGames();
			for (EventGame eg : eventGames) {
				if (eg.getGame().getCategory().equals(category))
					selectedEvents.add(event);
			}
		}
		return selectedEvents;
	}

	@Override
	public List<Event> getEventsByGame(Game game) {
		List<Event> allEvents = getAllEvents();
		List<Event> selectedEvents = new ArrayList<>();
		for (Event event : allEvents) {
			List<EventGame> eventGames = event.getEventGames();
			for (EventGame eg : eventGames) {
				if (eg.getGame().equals(game))
					selectedEvents.add(event);
			}
		}
		return selectedEvents;
	}

	@Override
	public List<Event> getEventsByKeyword(String keyword) {
		keyword = "%" + keyword + "%";
		String query = "SELECT e FROM Event e WHERE e.title OR e.description LIKE :input";
		List<Event> foundEvents = em.createQuery(query, Event.class)
				.setParameter("input", keyword)
				.getResultList();
		return foundEvents;
	}

	@Override
	public List<Event> getEventsByDate(LocalDate date) {
		List<Event> allEvents = getAllEvents();
		List<Event> selectedEvents = new ArrayList<>();
		for (Event event : allEvents) {
			if (event.getEventDate().equals(date)) {
				
			}
		}
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
