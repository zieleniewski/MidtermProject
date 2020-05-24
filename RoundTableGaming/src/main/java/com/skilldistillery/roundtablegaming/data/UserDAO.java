package com.skilldistillery.roundtablegaming.data;

import com.skilldistillery.roundtablegaming.entities.Address;
import com.skilldistillery.roundtablegaming.entities.User;

public interface UserDAO {
	public User createUser(User user, Address address);
	public User updateUser(int id, User user);
	boolean deleteUser(int id);
	public User checkLogin(User user);

}
