package com.skilldistillery.roundtablegaming.data;

import java.util.List;

import com.skilldistillery.roundtablegaming.entities.Address;

public interface AddressDAO {

	public Address createAddress(Address address);
	
	public Address deleteAddress(int id);
	
	public Address updateAddress(int id, Address updatedAddress);
	
	public List<Address> getAllAddresses();
	
	public Address getAddressById(int id);
	
	public Address getAddressByEventId(int id);
	
	public List<Address> getAddressesByZipCode(String zip);
	
}
