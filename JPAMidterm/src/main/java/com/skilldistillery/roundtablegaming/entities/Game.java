package com.skilldistillery.roundtablegaming.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

@Entity
public class Game {

	/*
	 * Object Fields
	 */
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private int id;
	private String title;
	private String description;
	@Column(name="min_players")
	private int minPlayers;
	@Column(name="max_players")
	private int maxPlayers;
	private boolean enabled;
	
	@OneToMany
	@JoinColumn(name="category_id")
	private Category category;
	
	@OneToOne
	@JoinColumn(name="creator_id")
	private User creator;

	
	/*
	 * Constructors
	 */
	public Game() {super();}
	
	
	/*
	 * toString
	 */
	@Override
	public String toString() {
		return "Game [id=" + id + ", title=" + title + ", description=" + description + ", minPlayers=" + minPlayers
				+ ", maxPlayers=" + maxPlayers + ", enabled=" + enabled + ", category=" + category + ", creator="
				+ creator + "]";
	}


	/*
	 * Getters and Setters
	 */
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


	public User getCreator() {
		return creator;
	}


	public void setCreator(User creator) {
		this.creator = creator;
	}


	/*
	 * Hash and Equals
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((category == null) ? 0 : category.hashCode());
		result = prime * result + ((creator == null) ? 0 : creator.hashCode());
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + (enabled ? 1231 : 1237);
		result = prime * result + id;
		result = prime * result + maxPlayers;
		result = prime * result + minPlayers;
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		if (category == null) {
			if (other.category != null)
				return false;
		} else if (!category.equals(other.category))
			return false;
		if (creator == null) {
			if (other.creator != null)
				return false;
		} else if (!creator.equals(other.creator))
			return false;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (enabled != other.enabled)
			return false;
		if (id != other.id)
			return false;
		if (maxPlayers != other.maxPlayers)
			return false;
		if (minPlayers != other.minPlayers)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	
	
	
}
