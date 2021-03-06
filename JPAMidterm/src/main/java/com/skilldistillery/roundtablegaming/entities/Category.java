package com.skilldistillery.roundtablegaming.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class Category {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	@NotNull
	private int id;
	@NotNull
	private String name;
	private String description;
	@OneToMany(mappedBy = "category", cascade = CascadeType.PERSIST)
	private List<Game> games;
	
	public Category() {}

	public Category(int id, String name, String description, List<Game> games) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.games = games;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public void addGame(Game game) {
		if (games == null) {
			games = new ArrayList<>();
		}
		if (!games.contains(game)) {
			games.add(game);
			if (game.getCategory() != null) {
				game.getCategory().getGames().remove(game);
			}
			game.setCategory(this);
		}
	}
	
	public void removeGame(Game game) {
		game.setCategory(null);
		if (games != null) {
			games.remove(game);
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
		Category other = (Category) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Category [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append("]");
		return builder.toString();
	}
	
}