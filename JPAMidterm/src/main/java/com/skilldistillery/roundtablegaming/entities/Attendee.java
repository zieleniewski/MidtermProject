package com.skilldistillery.roundtablegaming.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;

import com.sun.istack.NotNull;

@Entity
public class Attendee {

	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "user_id")
	@MapsId(value = "userId")
	private User user;
	@EmbeddedId
	private AttendeeId id = new AttendeeId();
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "event_game_id")
	@MapsId(value = "eventId")
	private EventGame eventGame;
	@Column(name = "event_rating")
	private Integer eventRating;
	@Column(name = "comment_by_attendee")
	private String attendeeComment;
	@NotNull
	private boolean enabled;

//	CONSTRUCTORS
	public Attendee() {}

	public Attendee(User user, AttendeeId id, EventGame eventGame, Integer eventRating, String attendeeComment,
			boolean enabled) {
		super();
		this.user = user;
		this.id = id;
		this.eventGame = eventGame;
		this.eventRating = eventRating;
		this.attendeeComment = attendeeComment;
		this.enabled = enabled;
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

	public EventGame getEventGame() {
		return eventGame;
	}

	public void setEventGame(EventGame eventGame) {
		this.eventGame = eventGame;
	}

	public Integer getEventRating() {
		return eventRating;
	}

	public void setEventRating(Integer eventRating) {
		this.eventRating = eventRating;
	}

	public String getAttendeeComment() {
		return attendeeComment;
	}

	public void setAttendeeComment(String attendeeComment) {
		this.attendeeComment = attendeeComment;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

//	 EQUALS AND HASHCODE

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

//	 TOSTRING

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Attendee [user=");
		builder.append(user);
		builder.append(", id=");
		builder.append(id);
		builder.append(", eventRating=");
		builder.append(eventRating);
		builder.append(", eventGame=");
		builder.append(eventGame);
		builder.append(", attendeeComment=");
		builder.append(attendeeComment);
		builder.append("]");
		return builder.toString();
	}

}
