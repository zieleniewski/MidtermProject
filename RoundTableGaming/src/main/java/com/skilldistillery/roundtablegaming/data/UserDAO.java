package com.skilldistillery.roundtablegaming.data;

import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.User;

public interface UserDAO {
	
	public User createUser(User user, Address address);
	
	public User updateUser(User user, Address address);
	
	public boolean enableUser(int id);
	
	public boolean disableUser(int id);
	
	public User checkLogin(User user);

}
