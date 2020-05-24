package com.skilldistillery.roundtablegaming.data;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.Event;

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
		em.persist(address);
		em.flush();
		return address;
	}
	
	@Override
	public List<Address> getAllAddresses() {
		String query= "SELECT a FROM Address a";
		List<Address> allAddresses = em.createQuery(query, Address.class)
				.getResultList();
		return allAddresses;
	}

	@Override
	public Address getAddressById(int id) {
		return em.find(Address.class, id);
	}

	@Override
	public Address getAddressByEventId(int id) {
		EventDAO ev = new EventDAOImpl();
		Event event= ev.getEventById(id);
		Address found = event.getAddress();
		return found;
	}

	@Override
	public List<Address> getAddressesByZipCode(String zip) {
		List<Address> allAddresses= getAllAddresses();
		List<Address> foundAddresses=null;
		for (Address address : allAddresses) {
			if(address.getZipCode().equals(zip))
				foundAddresses.add(address);
		}
		return foundAddresses;
	}
	
}
