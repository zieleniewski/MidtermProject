package com.skilldistillery.roundtablegaming.data;

import java.time.LocalDate;
import java.util.List;

import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.Attendee;
import com.skilldistillery.roundtablegaming.entities.Event;

public interface EventDAO {

	public Event createEvent(Event event, Integer[] eventGameIds);
	
	public List<Event> getAllEvents();
	
	public Event getEventById(int id);
	
	public List<Event> getEventsByAddress(Address address);
	
	public List<Event> getEventsByCategory(String category);
	
	public List<Event> getEventsByGame(String game);
	
	public List<Event> getEventsByDate(LocalDate date);
	
	public List<Event> getEventsByKeyword(String keyword);
	
	public List<Event> getEventsByZipCode(String zipCode);
	
	public List<Attendee> getEventAttendees(Event event);
	
	public List<Attendee> filterUniqueAttendees(List<Attendee> aList);
	
	public Event updateEvent(Event updatedEvent, Address address);
	
	public boolean enableEvent(int id);
	
	public boolean disableEvent(int id);
	
}
