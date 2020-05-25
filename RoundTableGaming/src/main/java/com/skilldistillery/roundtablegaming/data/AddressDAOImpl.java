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
			em.persist(address);
			em.flush();
		}
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
		Event event = ev.getEventById(id);
		Address found = event.getAddress();
		return found;
	}

	@Override
	public boolean checkAddress(Address address) {
		List<Address> allAddresses = getAllAddresses();
		boolean unique = false;
		
		for (Address dbAddress : allAddresses) {
			if (!dbAddress.getStreet1().equals(address.getStreet1())) {
				unique = true;
			}
			if (!dbAddress.getStreet2().equals(address.getStreet2())) {
				unique = true;
			}
			if (!dbAddress.getCity().equals(address.getCity())) {
				unique = true;
			}
			if (!dbAddress.getState().equals(address.getState())) {
				unique = true;
			}
			if (!dbAddress.getZipCode().equals(address.getZipCode())) {
				unique = true;
			}
		}
		return unique;
	}
	
}
