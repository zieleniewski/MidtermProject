package com.skilldistillery.roundtablegaming.data;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
	public User updateUser(int id, User user) {
		User updated = em.find(User.class, id);
		if (updated != null) {
			updated.setFirstName(user.getFirstName());
			updated.setLastName(user.getLastName());
			updated.setEmail(user.getEmail());
			updated.setPassword(user.getPassword());
			updated.setUsername(user.getUsername());
			updated.setAvatar(user.getAvatar());
			updated.setRole(user.getRole());
			updated.setEnabled(user.isEnabled());
		}
		return updated;
	}

	@Override
	public boolean deleteUser(int id) {
		boolean deleted = false;
		User toRemove = em.find(User.class, id);
		if (toRemove != null) {
			em.remove(toRemove);
			deleted = true;
		}
		return deleted;
	}

	@Override
	public User checkLogin(User user) {
		String jpql = "SELECT user FROM User user WHERE user.username = :username";

		User loggingUser = em.createQuery(jpql, User.class).setParameter("username", user.getUsername())
				.getSingleResult();
		System.out.println(loggingUser);
		if (loggingUser == null) {
			System.out.println("");
			return null;
		}

		if (loggingUser.getPassword().equals(user.getPassword())) {
		System.out.println("ping");	return loggingUser;
		} else {
			return null;
		}

	}

}
