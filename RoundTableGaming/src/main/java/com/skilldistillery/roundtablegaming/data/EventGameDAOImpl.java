package com.skilldistillery.roundtablegaming.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.roundtablegaming.entities.EventGame;

@Service
@Transactional
public class EventGameDAOImpl implements EventGameDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public EventGame create(EventGame eg) {
		em.persist(eg);
		em.flush();
		return eg;
	}

	@Override
	public EventGame update(EventGame eg) {
		EventGame updated = em.find(EventGame.class, eg.getId());
		updated.setDescription(eg.getDescription());
		updated.setGame(eg.getGame());
		updated.setEvent(eg.getEvent());
		updated.setMaxPlayers(eg.getMaxPlayers());
		updated.setMinPlayers(eg.getMinPlayers());
		updated.setPlayers(eg.getPlayers());
		updated.setStartTime(eg.getStartTime());
		em.persist(updated);
		em.flush();
		return updated;
	}

	@Override
	public boolean delete(int id) {
		boolean deleted= false;
		EventGame toRemove = em.find(EventGame.class, id);
		if(toRemove != null) {
			em.remove(toRemove);
			deleted=true;
		}
		return deleted;
	}

	@Override
	public EventGame findById(int id) {
		return em.find(EventGame.class, id);
	}
}
