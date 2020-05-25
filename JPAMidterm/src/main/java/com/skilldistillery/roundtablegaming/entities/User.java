package com.skilldistillery.roundtablegaming.entities;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import com.sun.istack.NotNull;

@Entity
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@NotNull
	private int id;
	@NotNull
	private String username;
	@NotNull
	private String password;
	private String role;
	@Column(name = "first_name")
	private String firstName;
	@Column(name = "last_name")
	private String lastName;
	private String email;
	@Column(name = "avatar_url")
	private String avatar;
	@Column(name = "create_date")
	private LocalDateTime created;
	@NotNull
	private boolean enabled;
	@NotNull
	private boolean admin;
	@OneToMany(mappedBy = "creator", cascade = CascadeType.PERSIST, fetch = FetchType.EAGER)
	private List<Game> games;
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name = "address_id")
	private Address address;
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<Attendee> attendees;
	@OneToMany(mappedBy = "organizer", cascade = CascadeType.PERSIST)
	private List<Event> organizerEvents;
	@OneToMany(mappedBy = "user", cascade = CascadeType.PERSIST)
	private List<EventComment> comments;
	@ManyToMany(mappedBy = "members", cascade = CascadeType.PERSIST)
	private List<Guild> guilds;

	public User() {}

	public User(int id, String username, String password, String role, String firstName, String lastName, String email,
			String avatar, LocalDateTime created, boolean enabled, boolean admin, List<Game> games, Address address,
			List<Attendee> attendees, List<Event> organizerEvents, List<EventComment> comments, List<Guild> guilds) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.role = role;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.avatar = avatar;
		this.created = created;
		this.enabled = enabled;
		this.admin = admin;
		this.games = games;
		this.address = address;
		this.attendees = attendees;
		this.organizerEvents = organizerEvents;
		this.comments = comments;
		this.guilds = guilds;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public LocalDateTime getCreated() {
		return created;
	}

	public void setCreated(LocalDateTime created) {
		this.created = created;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public boolean isAdmin() {
		return admin;
	}

	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	public List<Game> getGames() {
		return games;
	}

	public void setGames(List<Game> games) {
		this.games = games;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public List<Attendee> getAttendees() {
		return attendees;
	}

	public void setAttendees(List<Attendee> attendees) {
		this.attendees = attendees;
	}

	public List<Event> getOrganizerEvents() {
		return organizerEvents;
	}

	public void setOrganizerEvents(List<Event> events) {
		this.organizerEvents = events;
	}

	public List<EventComment> getComments() {
		return comments;
	}

	public void setComments(List<EventComment> comments) {
		this.comments = comments;
	}

	public List<Guild> getGuilds() {
		return guilds;
	}

	public void setGuilds(List<Guild> guilds) {
		this.guilds = guilds;
	}
	
	public void addGame(Game game) {
		if (games == null) {
			games = new ArrayList<>();
		}
		if (!games.contains(game)) {
			games.add(game);
			if (game.getCreator() != null) {
				game.getCreator().getGames().remove(game);
			}
			game.setCreator(this);
		}
	}
	
	public void removeGame(Game game) {
		game.setCreator(null);
		if (games != null) {
			games.remove(game);
		}
	}
	
	public void addAttendee(Attendee attendee) {
		if (attendees == null) {
			attendees = new ArrayList<>();
		}
		if (!attendees.contains(attendee)) {
			attendees.add(attendee);
			if (attendee.getUser() != null) {
				attendee.getUser().getAttendees().remove(attendee);
			}
			attendee.setUser(this);
		}
	}
	
	public void removeAttendee(Attendee attendee) {
		attendee.setUser(null);
		if (attendees != null) {
			attendees.remove(attendee);
		}
	}
	
	public void addOrganizerEvent(Event event) {
		if (organizerEvents == null) {
			organizerEvents = new ArrayList<>();
		}
		if (!organizerEvents.contains(event)) {
			organizerEvents.add(event);
			if (event.getOrganizer() != null) {
				event.getOrganizer().getOrganizerEvents().remove(event);
			}
			event.setOrganizer(this);
		}
	}
	
	public void removeOrganizerEvent(Event event) {
		event.setOrganizer(null);
		if (organizerEvents != null) {
			organizerEvents.remove(event);
		}
	}
	
	public void addEventComment(EventComment evComm) {
		if (comments == null) {
			comments = new ArrayList<>();
		}
		if (!comments.contains(evComm)) {
			comments.add(evComm);
			if (evComm.getUser() != null) {
				evComm.getUser().getComments().remove(evComm);
			}
			evComm.setUser(this);
		}
	}
	
	public void removeEventComment(EventComment evComm) {
		evComm.setUser(null);
		if (comments != null) {
			comments.remove(evComm);
		}
	}

	public void addGuild(Guild guild) {
		if (guilds == null) {
			guilds = new ArrayList<>();
		}
		if (!guilds.contains(guild)) {
			guilds.add(guild);
			guild.addMember(this);
		}
	}
	
	public void removeGuild(Guild guild) {
		if (guilds != null && guilds.contains(guild)) {
			guilds.remove(guild);
			guild.removeMember(this);
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("User [id=");
		builder.append(id);
		builder.append(", username=");
		builder.append(username);
		builder.append(", password=");
		builder.append(password);
		builder.append(", role=");
		builder.append(role);
		builder.append(", firstName=");
		builder.append(firstName);
		builder.append(", lastName=");
		builder.append(lastName);
		builder.append(", email=");
		builder.append(email);
		builder.append(", avatar=");
		builder.append(avatar);
		builder.append(", created=");
		builder.append(created);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append(", admin=");
		builder.append(admin);
		builder.append(", address=");
		builder.append(address);
		builder.append("]");
		return builder.toString();
	}

}
