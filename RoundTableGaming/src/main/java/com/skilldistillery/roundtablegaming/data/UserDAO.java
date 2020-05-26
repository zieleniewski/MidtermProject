package com.skilldistillery.roundtablegaming.data;

import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.User;

public interface UserDAO {
	
	public User createUser(User user, Address address);
	
	public User updateAccount(User user, Address address);
	
	public User updateUsername(User user);
	
	public User updatePassword(User user);
	
	public boolean enableUser(int id);
	
	public boolean disableUser(int id);
	
	public User checkLogin(User user);

}
