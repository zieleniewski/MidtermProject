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
		eg.setEnabled(true);
		em.persist(eg);
		em.flush();
		return eg;
	}

	@Override
	public EventGame update(EventGame eg) {
		EventGame updated = em.find(EventGame.class, eg.getId());
		if (updated != null) {
			updated.setEnabled(true);
			updated.setDescription(eg.getDescription());
			updated.setGame(eg.getGame());
			updated.setEvent(eg.getEvent());
			updated.setMaxPlayers(eg.getMaxPlayers());
			updated.setMinPlayers(eg.getMinPlayers());
			updated.setPlayers(eg.getPlayers());
			updated.setStartTime(eg.getStartTime());
			em.persist(updated);
			em.flush();
		}
		return updated;
	}

	@Override
	public EventGame findById(int id) {
		return em.find(EventGame.class, id);
	}

	@Override
	public boolean enable(int id) {
		EventGame enabled = em.find(EventGame.class, id);
		if (enabled != null) {
			enabled.setEnabled(true);
			em.persist(enabled);
			em.flush();
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean disable(int id) {
		EventGame disabled = em.find(EventGame.class, id);
		if (disabled != null) {
			disabled.setEnabled(false);
			em.persist(disabled);
			em.flush();
			return true;
		}
		else {
			return false;
		}
	}
}
