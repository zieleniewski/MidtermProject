package com.skilldistillery.roundtablegaming.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.roundtablegaming.entities.Address;
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
		List<Event> allEvents = em.createQuery(query, Event.class)
				.getResultList();
		return allEvents;
	}

	@Override
	public Event getEventById(int id) {
		return em.find(Event.class, id);
	}

	@Override
	public List<Event> getEventsByAddress(Address address) {
		String jpql = "SELECT e FROM Event e WHERE e.address.id = :search";
		List<Event> events = em.createQuery(jpql, Event.class)
				.setParameter("search", address.getId())
				.getResultList();
		return events;
	}

	@Override
	public List<Event> getEventsByCategory(String category) {
		List<Event> allEvents = getAllEvents();
		List<Event> selectedEvents = new ArrayList<>();
		for (Event event : allEvents) {
			List<EventGame> eventGames = event.getEventGames();
			for (EventGame eg : eventGames) {
				if (eg.getGame().getCategory().getName().equals(category))
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
		String query = "SELECT e FROM Event e WHERE e.title OR e.description "
				+ "LIKE '"+"%"+keyword+"%'";
		List<Event> events = em.createQuery(query, Event.class)
				.setParameter("input", keyword)
				.getResultList();
		return events;
	}

	@Override
	public List<Event> getEventsByDate(LocalDate date) {
		String jpql = "SELECT e FROM Event e WHERE e.eventDate = :search";
		List<Event> events = em.createQuery(jpql, Event.class)
				.setParameter("search", date)
				.getResultList();
		return events;
	}

	@Override
	public Event updateEvent(Event updatedEvent, int id) {
		Event event = em.find(Event.class, id);
		if (event != null) {
			event.setOrganizer(updatedEvent.getOrganizer());
			event.setAddress(updatedEvent.getAddress());
			event.setTitle(updatedEvent.getTitle());
			event.setDescription(updatedEvent.getDescription());
			event.setEventDate(updatedEvent.getEventDate());
			event.setStartTime(updatedEvent.getStartTime());
			event.setCapacity(updatedEvent.getCapacity());
			event.setImgURL(updatedEvent.getImgURL());
			event.setCreateDate(updatedEvent.getCreateDate());
			event.setLastUpdate(updatedEvent.getLastUpdate());
			event.setEventGames(updatedEvent.getEventGames());
			event.setEventComments(updatedEvent.getEventComments());
			em.persist(event);
			em.flush();
		}
		return event;
	}

	@Override
	public boolean enableEvent(int id) {
		Event event = em.find(Event.class, id);
		if (event != null) {
			event.setEnabled(true);
			em.persist(event);
			em.flush();
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean disableEvent(int id) {
		Event event = em.find(Event.class, id);
		if (event != null) {
			event.setEnabled(false);
			em.persist(event);
			em.flush();
			return true;
		}
		else {
			return false;
		}
	}

}
