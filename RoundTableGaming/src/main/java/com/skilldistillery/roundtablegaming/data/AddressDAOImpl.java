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
		address.setId(0);
		address.setEnabled(true);
		em.persist(address);
		em.flush();
		return address;
	}

	@Override
	public boolean enableAddress(int id) {
		Address enabledAddress = em.find(Address.class, id);
		if (enabledAddress != null) {
			enabledAddress.setEnabled(true);
			em.persist(enabledAddress);
			em.flush();
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public boolean disableAddress(int id) {
		Address disabledAddress = em.find(Address.class, id);
		if (disabledAddress != null) {
			disabledAddress.setEnabled(false);
			em.persist(disabledAddress);
			em.flush();
			return true;
		}
		else {
			return false;
		}
	}
	
	@Override
	public Address updateAddress(Address updatedAddress) {
		Address address = em.find(Address.class, updatedAddress.getId());
		if (address != null) {
			address.setStreet1(updatedAddress.getStreet1());
			address.setStreet2(updatedAddress.getStreet2());
			address.setCity(updatedAddress.getCity());
			address.setState(updatedAddress.getState());
			address.setZipCode(updatedAddress.getZipCode());
			address.setEnabled(true);
			em.persist(address);
			em.flush();
		}
		return address;
	}
	
	@Override
	public List<Address> getAllAddresses() {
		String query= "SELECT a FROM Address a WHERE a.enabled = true";
		List<Address> allAddresses = em.createQuery(query, Address.class)
				.getResultList();
		return allAddresses;
	}
	
	@Override
	public List<Address> getAddressesForAllEvents() {
		String query= "SELECT a FROM Address a JOIN FETCH a.events WHERE a.enabled = true";
		List<Address> allEventAddresses = em.createQuery(query, Address.class)
				.getResultList();
		return allEventAddresses;
	}

	@Override
	public Address getAddressById(int id) {
		return em.find(Address.class, id);
	}
	
	@Override
	public Address getAddressByEventId(int id) {
		EventDAO ev = new EventDAOImpl();
		Event event = ev.getEventById(id);
		Address found = event.getAddress();
		return found;
	}
	
	@Override
	public Address checkAddress(Address address) {
		Address newLinkedAddr;
		
		String check = "SELECT a FROM Address a WHERE a.street1 = :str1 "
				+ "AND a.street2 = :str2 AND a.city = :city AND a.state = :state "
				+ "AND a.zipCode = :zipCode";
		
		List<Address> addresses = em.createQuery(check, Address.class)
				.setParameter("str1", address.getStreet1())
				.setParameter("str2", address.getStreet2())
				.setParameter("city", address.getCity())
				.setParameter("state", address.getState())
				.setParameter("zipCode", address.getZipCode())
				.getResultList();
		
		if (addresses == null || addresses.size() < 1) {
			address.setEnabled(true);
			em.persist(address);
			return address;
		}
		else {
			newLinkedAddr = addresses.get(0);
			newLinkedAddr.setId(addresses.get(0).getId());
			newLinkedAddr.setEnabled(true);
			return newLinkedAddr;
		}
	}
	
}
