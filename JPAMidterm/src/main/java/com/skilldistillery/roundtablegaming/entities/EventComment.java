package com.skilldistillery.roundtablegaming.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "event_comment")
public class EventComment {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
//	@ManyToOne
//	@JoinColumn(name = "user_id")
//	private User user;
//	@ManyToOne
//	@JoinColumn(name = "event_id")
//	private Event event;
	@Column(name = "comment_date")
	private LocalDateTime commentDate;
	@Column(name = "content")
	private String comment;
	
	public EventComment() {}

	public EventComment(int id, User user, Event event, LocalDateTime commentDate, String comment) {
		super();
		this.id = id;
//		this.user = user;
//		this.event = event;
		this.commentDate = commentDate;
		this.comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

//	public User getUser() {
//		return user;
//	}
//
//	public void setUser(User user) {
//		this.user = user;
//	}
//
//	public Event getEvent() {
//		return event;
//	}
//
//	public void setEvent(Event event) {
//		this.event = event;
//	}

	public LocalDateTime getCommentDate() {
		return commentDate;
	}

	public void setCommentDate(LocalDateTime commentDate) {
		this.commentDate = commentDate;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		EventComment other = (EventComment) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EventComment [id=");
		builder.append(id);
//		builder.append(", user=");
//		builder.append(user);
//		builder.append(", event=");
//		builder.append(event);
		builder.append(", commentDate=");
		builder.append(commentDate);
		builder.append(", comment=");
		builder.append(comment);
		builder.append("]");
		return builder.toString();
	}
}
