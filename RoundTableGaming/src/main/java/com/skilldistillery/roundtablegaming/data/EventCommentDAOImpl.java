package com.skilldistillery.roundtablegaming.data;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.roundtablegaming.entities.EventComment;

@Service
@Transactional
public class EventCommentDAOImpl implements EventCommentDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public EventComment createEventComment(EventComment ev) {
		em.persist(ev);
		em.flush();
		return ev;
	}

	@Override
	public EventComment updateEventComment(EventComment ev) {
		EventComment updated= em.find(EventComment.class, ev.getId());
		
		
		return updated;
	}
	
	@Override
	public List<EventComment> getAllEventComments() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<EventComment> getEventCommentsByEventId(int eventId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public EventComment getEventCommentById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean deleteEventComment(int id) {
		// TODO Auto-generated method stub
		return false;
	}

	
}
