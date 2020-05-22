package com.skilldistillery.roundtablegaming.data;

import com.skilldistillery.roundtablegaming.entities.Address;

public interface AddressDAO {

	public Address createAddress(Address address);
	
	public Address deleteAddress(int id);
	
	public Address updateAddress(int id, Address updatedAddress);
	
	public Address searchByZipCode(String zipCode);
}
