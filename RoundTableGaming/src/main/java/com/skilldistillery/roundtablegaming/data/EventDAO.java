package com.skilldistillery.roundtablegaming.data;

import java.time.LocalDate;
import java.util.List;

import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.Category;
import com.skilldistillery.roundtablegaming.entities.Event;
import com.skilldistillery.roundtablegaming.entities.Game;

public interface EventDAO {

	public Event createEvent(Event event);
	
	public List<Event> getAllEvents();
	
	public Event getEventById(int id);
	
	public List<Event> getEventsByAddress(Address address);
	
	public List<Event> getEventsByCategory(Category category);
	
	public List<Event> getEventsByGame(Game game);
	
	public List<Event> getEventsByDate(LocalDate date);
	
	public List<Event> getEventsByKeyword(String keyword);
	
	public Event updateEvent(Event event, int id);
	
	public boolean deleteEvent(int id);
	
}
