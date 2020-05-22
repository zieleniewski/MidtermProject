package com.skilldistillery.roundtablegaming.data;

import com.skilldistillery.roundtablegaming.entities.Attendee;

public interface AttendeeDAO {

	public Attendee create(Attendee attn);
	public Attendee update(Attendee attn);
}
