package com.skilldistillery.roundtablegaming.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable

public class AttendeeId implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "user_id")
	private int userId;

	@Column(name = "event_game_id")
	private int eventId;

//	CONSTRUCTORS
	public AttendeeId() {

	}

	public AttendeeId(int userId, int eventId) {
		super();
		this.userId = userId;
		this.eventId = eventId;
	}

//	GETTERS AND SETTERS
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public int getEventId() {
		return eventId;
	}

	public void setEventId(int eventId) {
		this.eventId = eventId;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

//	EQULAS AND HASHCODE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + eventId;
		result = prime * result + userId;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		AttendeeId other = (AttendeeId) obj;
		if (eventId != other.eventId)
			return false;
		if (userId != other.userId)
			return false;
		return true;
	}

//	TOSTRING
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("AttendeeId [userId=").append(userId).append(", eventId=").append(eventId).append("]");
		return builder.toString();
	}
}
