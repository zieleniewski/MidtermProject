package com.skilldistillery.roundtablegaming.data;

import com.skilldistillery.roundtablegaming.entities.Attendee;
import com.skilldistillery.roundtablegaming.entities.AttendeeId;

public interface AttendeeDAO {

	public Attendee create(Attendee attn);
	
	public Attendee update(Attendee attn);
	
	public boolean enable(AttendeeId id);
	
	public boolean disable(AttendeeId id);
}
