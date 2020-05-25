package com.skilldistillery.roundtablegaming.entities;

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
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table(name = "event_game")
public class EventGame {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	private String description;
	@Column(name = "min_players")
	private Integer minPlayers;
	@Column(name = "max_players")
	private Integer maxPlayers;
	@Column(name = "start_time")
	private LocalTime startTime;
	@NotNull
	private boolean enabled;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "game_id")
	@NotNull
	private Game game;
	@OneToMany(mappedBy = "eventGame", cascade = CascadeType.PERSIST)
	private List<Attendee> players;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "event_id")
	private Event event;
	
	public EventGame() {}

	public EventGame(int id, String description, Integer minPlayers, Integer maxPlayers, LocalTime startTime, boolean enabled, Game game,
			List<Attendee> players, Event event) {
		super();
		this.id = id;
		this.description = description;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.startTime = startTime;
		this.enabled = enabled;
		this.game = game;
		this.players = players;
		this.event = event;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Integer getMinPlayers() {
		return minPlayers;
	}

	public void setMinPlayers(Integer minPlayers) {
		this.minPlayers = minPlayers;
	}

	public Integer getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(Integer maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public LocalTime getStartTime() {
		return startTime;
	}

	public void setStartTime(LocalTime startTime) {
		this.startTime = startTime;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<Attendee> getPlayers() {
		return players;
	}

	public void setPlayers(List<Attendee> players) {
		this.players = players;
	}

	public Event getEvent() {
		return event;
	}

	public void setEvent(Event event) {
		this.event = event;
	}

	public void addAttendee(Attendee attendee) {
		if (players == null) {
			players = new ArrayList<>();
		}
		if (!players.contains(attendee)) {
			players.add(attendee);
			if (attendee.getEventGame() != null) {
				attendee.getEventGame().getPlayers().remove(attendee);
			}
			attendee.setEventGame(this);
		}
	}
	
	public void removeAttendee(Attendee user) {
		user.setEventGame(null);
		if (players != null) {
			players.remove(user);
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
		EventGame other = (EventGame) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("EventGame [id=");
		builder.append(id);
		builder.append(", description=");
		builder.append(description);
		builder.append(", minPlayers=");
		builder.append(minPlayers);
		builder.append(", maxPlayers=");
		builder.append(maxPlayers);
		builder.append(", startTime=");
		builder.append(startTime);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append(", game=");
		builder.append(game);
		builder.append(", event=");
		builder.append(event);
		builder.append("]");
		return builder.toString();
	}
	
}
