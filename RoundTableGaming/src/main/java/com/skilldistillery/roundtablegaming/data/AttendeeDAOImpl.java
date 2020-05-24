package com.skilldistillery.roundtablegaming.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.roundtablegaming.entities.Attendee;
import com.skilldistillery.roundtablegaming.entities.AttendeeId;

@Service
@Transactional
public class AttendeeDAOImpl implements AttendeeDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public Attendee create(Attendee attn) {
		em.persist(attn);
		em.flush();
		return attn;
	}

	@Override
	public Attendee update(Attendee attn) {
		Attendee updated = em.find(Attendee.class, attn.getId());
		updated.setUser(attn.getUser());
		updated.setEventGame(attn.getEventGame());
		updated.setEventRating(attn.getEventRating());
		updated.setAttendeeComment(attn.getAttendeeComment());
		em.persist(updated);
		em.flush();
		return updated;
	}

	@Override
	public Attendee enable(AttendeeId id) {
		Attendee enabled = em.find(Attendee.class, id);
		enabled.setEnabled(true);
		em.persist(enabled);
		em.flush();
		return enabled;
	}

	@Override
	public Attendee disable(AttendeeId id) {
		Attendee disabled = em.find(Attendee.class, id);
		disabled.setEnabled(false);
		em.persist(disabled);
		em.flush();
		return disabled;
	}

}
