package com.skilldistillery.roundtablegaming.data;

import com.skilldistillery.roundtablegaming.entities.Attendee;
import com.skilldistillery.roundtablegaming.entities.AttendeeId;
import com.skilldistillery.roundtablegaming.entities.User;

public interface AttendeeDAO {

	public Attendee create(User user, int egId);
	
	public Attendee update(Attendee attn);
	
	public boolean enable(AttendeeId id);
	
	public boolean disable(AttendeeId id);
}
