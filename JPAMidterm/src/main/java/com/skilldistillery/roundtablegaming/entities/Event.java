package com.skilldistillery.roundtablegaming.entities;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
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

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.sun.istack.NotNull;

@Entity
public class Event {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	@NotNull
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "organizer_id")
	private User organizer;
	@NotNull
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "address_id")
	private Address address;
	@NotNull
	private String title;
	private String description;
	@Column(name = "event_date")
	private LocalDate eventDate;
	@Column(name = "start_time")
	private LocalTime startTime;
	private Integer capacity;
	@Column(name = "img_url")
	private String imgURL;
	@CreationTimestamp
	@Column(name = "create_date")
	private LocalDateTime createDate;
	@Column(name = "last_update")
	@UpdateTimestamp
	private LocalDateTime lastUpdate;
	@NotNull
	private boolean enabled;
	@OneToMany(mappedBy = "event", cascade = CascadeType.PERSIST)
	private List<EventGame> eventGames;
	@OneToMany(mappedBy = "event", cascade = CascadeType.PERSIST)
	private List<EventComment> eventComments;
	
	public Event() {}

	public Event(int id, User organizer, Address address, String title, String description, LocalDate eventDate,
			LocalTime startTime, Integer capacity, String imgURL, LocalDateTime createDate, LocalDateTime lastUpdate, boolean enabled,
			List<EventGame> eventGames, List<EventComment> eventComments) {
		super();
		this.id = id;
		this.organizer = organizer;
		this.address = address;
		this.title = title;
		this.description = description;
		this.eventDate = eventDate;
		this.startTime = startTime;
		this.capacity = capacity;
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

	public LocalDate getEventDate() {
		return eventDate;
	}

	public void setEventDate(LocalDate eventDate) {
		this.eventDate = eventDate;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public Integer getCapacity() {
		return capacity;
	}

	public void setCapacity(Integer capacity) {
		this.capacity = capacity;
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

	public void addEventGame(EventGame evGame) {
		if (eventGames == null) {
			eventGames = new ArrayList<>();
		}
		if (!eventGames.contains(evGame)) {
			eventGames.add(evGame);
			if (evGame.getEvent() != null) {
				evGame.getEvent().getEventGames().remove(evGame);
			}
			evGame.setEvent(this);
		}
	}
	
	public void removeEventGame(EventGame evGame) {
		evGame.setEvent(null);
		if (eventGames != null) {
			eventGames.remove(evGame);
		}
	}
	
	public void addEventComment(EventComment evComm) {
		if (eventComments == null) {
			eventComments = new ArrayList<>();
		}
		if (!eventComments.contains(evComm)) {
			eventComments.add(evComm);
			if (evComm.getEvent() != null) {
				evComm.getEvent().getEventComments().remove(evComm);
			}
			evComm.setEvent(this);
		}
	}
	
	public void removeEventComment(EventComment evComm) {
		evComm.setEvent(null);
		if (eventComments != null) {
			eventComments.remove(evComm);
		}
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
		builder.append(", capacity=");
		builder.append(capacity);
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
