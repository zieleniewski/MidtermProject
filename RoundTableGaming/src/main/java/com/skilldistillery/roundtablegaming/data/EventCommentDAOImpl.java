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
		
		if(updated != null) {
			updated.setComment(updated.getComment());
			/*
			 * Other fields should not be manipulated
			 * The DateTime should be generated on creation
			 * If we want a lastUpdated field that should be separate because there are doesn't seem to be a need for a field to update this
			 * Or we can update with a new DateTimeStamp
			 * updated.setCommentTime(LocalDateTime.now())
			 * or something.
			 */
		}
		
		em.persist(updated);
		em.flush();
		
		return updated;
	}
	
	/*
	 * Mostly to be used internally for filtering out lists
	 */
	@Override
	public List<EventComment> getAllEventComments() {
		
		String query= "SELECT ec FROM EventComment ec";
		List<EventComment> allCommentsEver = em.createQuery(query, EventComment.class).getResultList();
		
		return allCommentsEver;
	}

	@Override
	public List<EventComment> getEventCommentsByEventId(int eventId) {
		/*
		 * Little shaky on this one... It seems like it should work, but I
		 * went off script and tried this a different way than populating all comments ever
		 * because I don't think that's the most efficient way with something as unrelated as all comments
		 * ever posted on our site.
		 */
		String query= "SELECT ec FROM EventComment ec WHERE ec.event.id = "+eventId;
		List<EventComment> foundComments = em.createQuery(query).getResultList();
		return foundComments;
	}

	//standard, maybe used in forLoop
	@Override
	public EventComment getEventCommentById(int id) {
		
		return em.find(EventComment.class, id);
	}

	/*
	 * If we specify who can delete a comment, ie admin or event creator or comment maker, 
	 * that validation needs to be done outside of this method. 
	 */
	@Override
	public boolean deleteEventComment(int id) {
		boolean deleted = false;
		EventComment toRemove= em.find(EventComment.class, id);
		
		if(toRemove != null) {
			em.remove(toRemove);
			deleted= true;
		}
		
		return deleted;
	}

	
}
