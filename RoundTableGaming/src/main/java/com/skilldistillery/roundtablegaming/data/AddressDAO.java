package com.skilldistillery.roundtablegaming.data;

import java.util.List;

import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.Event;

public interface AddressDAO {

	public Address createAddress(Address address);
	
	public boolean enableAddress(int id);
	
	public boolean disableAddress(int id);
	
	public Address updateAddress(Address updatedAddress);
	
	public List<Address> getAllAddresses();
	
	public Address getAddressById(int id);
	
	public Address getAddressByEventId(int id);
	
	public List<Event> searchByZipCode(String zipCode);
	
}
