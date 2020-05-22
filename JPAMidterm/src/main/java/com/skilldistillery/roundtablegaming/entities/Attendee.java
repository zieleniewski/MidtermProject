package com.skilldistillery.roundtablegaming.entities;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

@Entity
public class Attendee {

	@ManyToOne
	@JoinColumn(name = "user_id")
	@MapsId(value = "userId")
	private User user;

	@EmbeddedId
	private AttendeeId id = new AttendeeId();

	private int eventRating;

	@Column(name = "comment_by_attendee")
	private String attendeeComment;

//	CONSTRUCTORS
	public Attendee() {

	}

	public Attendee(User user, AttendeeId id, int eventRating, String attendeeComment) {
		super();
		this.user = user;
		this.id = id;
		this.eventRating = eventRating;
		this.attendeeComment = attendeeComment;
	}

//	GETTERS AND SETTERS
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public AttendeeId getId() {
		return id;
	}

	public void setId(AttendeeId id) {
		this.id = id;
	}

	public int getEventRating() {
		return eventRating;
	}

	public void setEventRating(int eventRating) {
		this.eventRating = eventRating;
	}

	public String getAttendeeComment() {
		return attendeeComment;
	}

	public void setAttendeeComment(String attendeeComment) {
		this.attendeeComment = attendeeComment;
	}

//	EQUALS AND HASHCODE
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((attendeeComment == null) ? 0 : attendeeComment.hashCode());
		result = prime * result + eventRating;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((user == null) ? 0 : user.hashCode());
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
		Attendee other = (Attendee) obj;
		if (attendeeComment == null) {
			if (other.attendeeComment != null)
				return false;
		} else if (!attendeeComment.equals(other.attendeeComment))
			return false;
		if (eventRating != other.eventRating)
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (user == null) {
			if (other.user != null)
				return false;
		} else if (!user.equals(other.user))
			return false;
		return true;
	}

//	TOSTRING
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Attendee [user=").append(user).append(", id=").append(id).append(", eventRating=")
				.append(eventRating).append(", attendeeComment=").append(attendeeComment).append("]");
		return builder.toString();
	}

}
