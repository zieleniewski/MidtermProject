package com.skilldistillery.roundtablegaming.data;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.roundtablegaming.entities.EventComment;

@Service
@Transactional
public class EventCommentDAOImpl implements EventCommentDAO {

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
		EventComment updated = em.find(EventComment.class, ev.getId());
		if (updated != null) {
			updated.setComment(ev.getComment());
			updated.setLastUpdated(LocalDateTime.now());
			em.persist(updated);
			em.flush();
		}
		return updated;
	}

	@Override
	public List<EventComment> getAllEventComments() {
		String query = "SELECT ec FROM EventComment ec";
		List<EventComment> allCommentsEver = em.createQuery(query, EventComment.class)
				.getResultList();
		return allCommentsEver;
	}

	@Override
	public List<EventComment> getEventCommentsByEventId(int eventId) {
		String query = "SELECT ec FROM EventComment ec WHERE ec.event.id = :eid";
		List<EventComment> foundComments = em.createQuery(query, EventComment.class)
				.setParameter("eid", eventId)
				.getResultList();
		return foundComments;
	}

	@Override
	public EventComment getEventCommentById(int id) {
		return em.find(EventComment.class, id);
	}

	@Override
	public boolean enableEventComment(int id) {
		EventComment enabled = em.find(EventComment.class, id);
		if (enabled != null) {
			enabled.setEnabled(false);
			em.persist(enabled);
			em.flush();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public boolean disableEventComment(int id) {
		EventComment disabled = em.find(EventComment.class, id);
		if (disabled != null) {
			disabled.setEnabled(false);
			em.persist(disabled);
			em.flush();
			return true;
		} else {
			return false;
		}
	}

}
