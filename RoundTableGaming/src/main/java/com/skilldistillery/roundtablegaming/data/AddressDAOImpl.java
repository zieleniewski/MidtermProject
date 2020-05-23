package com.skilldistillery.roundtablegaming.data;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.roundtablegaming.entities.Address;

@Service
@Transactional
public class AddressDAOImpl implements AddressDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public Address createAddress(Address address) {
		em.persist(address);
		em.flush();
		return address;
	}

	@Override
	public Address deleteAddress(int id) {
		Address deleteAddress = em.find(Address.class, id);
		em.remove(deleteAddress);
		return deleteAddress;
	}

	@Override
	public Address updateAddress(int id, Address updatedAddress) {
		Address address = em.find(Address.class, id);
		address.setCity(updatedAddress.getCity());
		address.setState(updatedAddress.getState());
		address.setStreet1(updatedAddress.getStreet1());
		address.setStreet2(updatedAddress.getStreet2());
		address.setZipCode(updatedAddress.getZipCode());
		return address;
	}

//	@Override
//	public List<Event> searchByZipCode(String zipCode) {
//		List<Event> events;
//		String jpql = "SELECT event FROM Event event WHERE Address.zipCode = :zipCode";
//		events = em.createQuery(jpql, Event.class).setParameter("zipCode", zipCode)
//				.getResultList();
//		return events;
//	}

}
