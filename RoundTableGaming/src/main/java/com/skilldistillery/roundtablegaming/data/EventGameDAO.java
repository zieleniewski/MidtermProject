package com.skilldistillery.roundtablegaming.data;

import com.skilldistillery.roundtablegaming.entities.EventGame;

public interface EventGameDAO {

	public EventGame create(EventGame eg);
	public EventGame update(EventGame eg);
	public EventGame delete(int id);
	public EventGame findById(int id);
}
