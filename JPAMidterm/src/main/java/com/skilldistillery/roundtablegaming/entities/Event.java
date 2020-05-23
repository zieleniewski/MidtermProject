package com.skilldistillery.roundtablegaming.entities;

import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@ManyToOne
	@JoinColumn(name = "organizer_id")
	private User organizer;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "address_id")
	private Address address;
	private String title;
	private String description;
	@Column(name = "event_date")
	private LocalDateTime eventDate;
	@Column(name = "start_time")
	private LocalTime startTime;
	@Column(name = "img_url")
	private String imgURL;
	@Column(name = "create_date")
	private LocalDateTime createDate;
	@Column(name = "last_update")
	private LocalDateTime lastUpdate;
	private boolean enabled;
	@OneToMany(mappedBy = "event")
	private List<EventGame> eventGames;
	@OneToMany(mappedBy = "event")
	private List<EventComment> eventComments;
	
	public Event() {}

	public Event(int id, User organizer, Address address, String title, String description, LocalDateTime eventDate,
			LocalTime startTime, String imgURL, LocalDateTime createDate, LocalDateTime lastUpdate, boolean enabled,
			List<EventGame> eventGames, List<EventComment> eventComments) {
		super();
		this.id = id;
		this.organizer = organizer;
		this.address = address;
		this.title = title;
		this.description = description;
		this.eventDate = eventDate;
		this.startTime = startTime;
		this.imgURL = imgURL;
		this.createDate = createDate;
		this.lastUpdate = lastUpdate;
		this.enabled = enabled;
		this.eventGames = eventGames;
		this.eventComments = eventComments;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getOrganizer() {
		return organizer;
	}

	public void setOrganizer(User organizer) {
		this.organizer = organizer;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDateTime getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDateTime eventDate) {
		this.eventDate = eventDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public String getImgURL() {
		return imgURL;
	}

	public void setImgURL(String imgURL) {
		this.imgURL = imgURL;
	}

	public LocalDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(LocalDateTime createDate) {
		this.createDate = createDate;
	}

	public LocalDateTime getLastUpdate() {
		return lastUpdate;
	}

	public void setLastUpdate(LocalDateTime lastUpdate) {
		this.lastUpdate = lastUpdate;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<EventGame> getEventGames() {
		return eventGames;
	}

	public void setEventGames(List<EventGame> eventGames) {
		this.eventGames = eventGames;
	}

	public List<EventComment> getEventComments() {
		return eventComments;
	}

	public void setEventComments(List<EventComment> eventComments) {
		this.eventComments = eventComments;
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
		Event other = (Event) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Event [id=");
		builder.append(id);
		builder.append(", organizer=");
		builder.append(organizer);
		builder.append(", address=");
		builder.append(address);
		builder.append(", title=");
		builder.append(title);
		builder.append(", description=");
		builder.append(description);
		builder.append(", eventDate=");
		builder.append(eventDate);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", imgURL=");
		builder.append(imgURL);
		builder.append(", createDate=");
		builder.append(createDate);
		builder.append(", lastUpdate=");
		builder.append(lastUpdate);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append("]");
		return builder.toString();
	}
	
}
