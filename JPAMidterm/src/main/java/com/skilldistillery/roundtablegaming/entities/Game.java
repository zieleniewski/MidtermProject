package com.skilldistillery.roundtablegaming.entities;

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

import com.sun.istack.NotNull;

@Entity
public class Game {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@NotNull
	private int id;
	@NotNull
	private String title;
	@Column(name="min_players")
	private int minPlayers;
	@Column(name="max_players")
	private int maxPlayers;
	private String description;
	@NotNull
	private boolean enabled;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "category_id")
	@NotNull
	private Category category;
	@OneToMany(mappedBy = "game", cascade = CascadeType.PERSIST)
	private List<EventGame> eventGames;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "creator_id")
	@NotNull
	private User creator;
	
	public Game() {}
	
	public Game(int id, String title, int minPlayers, int maxPlayers, String description, boolean enabled,
			Category category, List<EventGame> eventGames, User creator) {
		super();
		this.id = id;
		this.title = title;
		this.minPlayers = minPlayers;
		this.maxPlayers = maxPlayers;
		this.description = description;
		this.enabled = enabled;
		this.category = category;
		this.eventGames = eventGames;
		this.creator = creator;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public int getMinPlayers() {
		return minPlayers;
	}

	public void setMinPlayers(int minPlayers) {
		this.minPlayers = minPlayers;
	}

	public int getMaxPlayers() {
		return maxPlayers;
	}

	public void setMaxPlayers(int maxPlayers) {
		this.maxPlayers = maxPlayers;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public List<EventGame> getEventGames() {
		return eventGames;
	}

	public void setEventGames(List<EventGame> eventGames) {
		this.eventGames = eventGames;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
	}

	public void addEventGame(EventGame evGame) {
		if (eventGames == null) {
			eventGames = new ArrayList<>();
		}
		if (!eventGames.contains(evGame)) {
			eventGames.add(evGame);
			if (evGame.getGame() != null) {
				evGame.getGame().getEventGames().remove(evGame);
			}
			evGame.setGame(this);
		}
	}
	
	public void removeEventGame(EventGame evGame) {
		evGame.setGame(null);
		if (eventGames != null) {
			eventGames.remove(evGame);
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
		Game other = (Game) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Game [id=");
		builder.append(id);
		builder.append(", title=");
		builder.append(title);
		builder.append(", minPlayers=");
		builder.append(minPlayers);
		builder.append(", maxPlayers=");
		builder.append(maxPlayers);
		builder.append(", description=");
		builder.append(description);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append(", category=");
		builder.append(category);
		builder.append(", creator=");
		builder.append(creator);
		builder.append("]");
		return builder.toString();
	}
	
}


