package com.skilldistillery.roundtablegaming.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceException;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.User;

@Service
@Transactional
public class UserDAOImpl implements UserDAO {
	
	@PersistenceContext
	private EntityManager em;

	@Override
	public User createUser(User user, Address address) {
		address.addUser(user);
		em.persist(address);
		em.flush();
		return user;
	}

	@Override
	public User updateAccount(User user, Address address) {
		User updated = em.find(User.class, user.getId());
		if (updated != null) {
			updated.setFirstName(user.getFirstName());
			updated.setLastName(user.getLastName());
			updated.setEmail(user.getEmail());
			updated.setAvatar(user.getAvatar());
			updated.setRole(user.getRole());
			updated.setEnabled(user.isEnabled());
			updated.setAddress(address);
			em.persist(updated);
			em.flush();
		}
		return updated;
	}

	@Override
	public User updateUsername(User user) {
		User updated = em.find(User.class, user.getId());
		if (updated != null) {
			updated.setUsername(user.getUsername());
			em.persist(updated);
			em.flush();
		}
		return updated;
	}
	
	@Override
	public User updatePassword(User user) {
		User updated = em.find(User.class, user.getId());
		if (updated != null) {
			updated.setPassword(user.getPassword());
			em.persist(updated);
			em.flush();
		}
		return updated;
	}
	
	@Override
	public boolean enableUser(int id) {
		User enabled = em.find(User.class, id);
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
	public boolean disableUser(int id) {
		User disabled = em.find(User.class, id);
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
	
	@Override
	public User checkLogin(User user) {
		String jpql = "SELECT user FROM User user WHERE user.username = :username";
		try {
			User loggingUser = em.createQuery(jpql, User.class)
					.setParameter("username", user.getUsername())
					.getSingleResult();
			if (loggingUser.getPassword().equals(user.getPassword())) {
				System.out.println("ping");
				return loggingUser;
			}
			
		} catch (PersistenceException e) {
			return null;
		}
		return null;
	}

	@Override
	public User getUserById(int id) {
		return em.find(User.class, id);
	}

}
