package com.skilldistillery.roundtablegaming.data;

import java.util.List;

import com.skilldistillery.roundtablegaming.entities.EventComment;

public interface EventCommentDAO {
	
	public EventComment createEventComment(EventComment ev);
	
	public EventComment updateEventComment(EventComment ev);
	
	public List<EventComment> getAllEventComments();
	
	public List<EventComment> getEventCommentsByEventId(int eventId);
	
	//don't know if we need this. Maybe in a for loop?
	public EventComment getEventCommentById(int id);
	
	public boolean enableEventComment(int id);
	
	public boolean disableEventComment(int id);
	
}
