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
//				System.out.println("\n\n"+dbAddress.getStreet1());
//				System.out.println("IF: " + unique);
//				System.out.println(address.getStreet1());
			} else {
				unique = false;
//				System.out.println("ELSE: " + unique);
			}
			if (dbAddress.getStreet2() != null ) {
				if (!dbAddress.getStreet2().equals(address.getStreet2())) {
					unique = true;
//					System.out.println("\n"+dbAddress.getStreet2());
//					System.out.println("IF: " + unique);
//					System.out.println(address.getStreet2());
				} else {
					unique = false;
//					System.out.println("ELSE: " + unique);
				}
			}
			if (!dbAddress.getCity().equals(address.getCity())) {
				unique = true;
//				System.out.println("\n"+dbAddress.getCity());
//				System.out.println("IF: " + unique);
//				System.out.println(address.getCity());
			} else {
				unique = false;
//				System.out.println("ELSE: " + unique);
			}
			if (!dbAddress.getState().equals(address.getState())) {
				unique = true;
//				System.out.println("\n"+dbAddress.getState());
//				System.out.println("IF: " + unique);
//				System.out.println(address.getState());
			} else {
				unique = false;
//				System.out.println("ELSE: " + unique);
			}
			if (!dbAddress.getZipCode().equals(address.getZipCode())) {
				unique = true;
//				System.out.println("\n"+dbAddress.getZipCode());
//				System.out.println("IF: " + unique);
//				System.out.println(address.getZipCode());
			} else {
				unique = false;
//				System.out.println("ELSE: " + unique + "\n\n");
			}
			if (unique == false) {break;}
		}
		return unique;
	}
	
}
