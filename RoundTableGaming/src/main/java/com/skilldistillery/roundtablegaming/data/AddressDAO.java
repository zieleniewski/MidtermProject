package com.skilldistillery.roundtablegaming.data;

import java.util.List;

import com.skilldistillery.roundtablegaming.entities.Address;

public interface AddressDAO {

	public Address createAddress(Address address);
	
	public boolean enableAddress(int id);
	
	public boolean disableAddress(int id);
	
	public Address updateAddress(Address updatedAddress);
	
	public List<Address> getAllAddresses();
	
	public List<Address> getAddressesForAllEvents();
	
	public Address getAddressById(int id);
	
	public Address getAddressByEventId(int id);
	
	public boolean checkAddress(Address address);
	
}
