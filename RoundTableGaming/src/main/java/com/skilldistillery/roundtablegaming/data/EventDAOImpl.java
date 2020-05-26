package com.skilldistillery.roundtablegaming.data;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.Attendee;
import com.skilldistillery.roundtablegaming.entities.Event;
import com.skilldistillery.roundtablegaming.entities.EventGame;

@Service
@Transactional
public class EventDAOImpl implements EventDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Event createEvent(Event event) {
		System.out.println(event);
		Address tempAddr = event.getAddress();
		em.persist(tempAddr);
		event.setAddress(tempAddr);
		em.persist(event);
		em.flush();
		return event;
	}

	@Override
	public List<Event> getAllEvents() {
		String query = "SELECT e FROM Event e ORDER BY e.eventDate";
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
	public List<Event> getEventsByGame(String game) {
		List<Event> allEvents = getAllEvents();
		List<Event> selectedEvents = new ArrayList<>();
		for (Event event : allEvents) {
			List<EventGame> eventGames = event.getEventGames();
			for (EventGame eg : eventGames) {
				if (eg.getGame().getTitle().equals(game))
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
	public List<Event> getEventsByZipCode(String zipCode) {
		String jpql = "SELECT e FROM Event e WHERE address.zipCode = :zipCode";
		List<Event> events = em.createQuery(jpql, Event.class)
				.setParameter("zipCode", zipCode)
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
	public List<Attendee> getEventAttendees(Event event) {
		List<Attendee> attendees = new ArrayList<>();
		String jpql = "SELECT a FROM Attendee a JOIN a.eventGame g WHERE "
				+ "g.event.id = :id";
		attendees = em.createQuery(jpql, Attendee.class)
				.setParameter("id", event.getId())
				.getResultList();		
		return attendees;
	}

	@Override
	public List<Attendee> filterUniqueAttendees(List<Attendee> aList) {
		List<Attendee> filtered = aList.stream().distinct().collect(Collectors.toList());
		return filtered;
	}
	
	@Override
	public Event updateEvent(Event updatedEvent, Address address) {
		Event event = em.find(Event.class, updatedEvent.getId());
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
			event.setAddress(address);
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
