package com.skilldistillery.roundtablegaming.data;

import com.skilldistillery.roundtablegaming.entities.User;

public interface UserDAO {
	public User createUser(User user);
	public User updateUser(int id, User user);
	boolean deleteUser(int id);

}
