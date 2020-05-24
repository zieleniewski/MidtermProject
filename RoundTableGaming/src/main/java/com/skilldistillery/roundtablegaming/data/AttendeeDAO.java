package com.skilldistillery.roundtablegaming.data;

import com.skilldistillery.roundtablegaming.entities.Attendee;
import com.skilldistillery.roundtablegaming.entities.AttendeeId;

public interface AttendeeDAO {

	public Attendee create(Attendee attn);
	public Attendee update(Attendee attn, AttendeeId id);
	public Attendee enable(AttendeeId id);
	public Attendee disable(AttendeeId id);
}
