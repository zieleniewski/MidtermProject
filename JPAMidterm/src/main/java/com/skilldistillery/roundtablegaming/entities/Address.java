package com.skilldistillery.roundtablegaming.entities;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String street1;
	private String street2;
	private String city;
	private String state;
	@Column(name = "zip_code")
	private String zipCode;
	private boolean enabled;
	@OneToMany(mappedBy = "address", cascade = CascadeType.PERSIST)
	private List<Event> events;
	@OneToMany(mappedBy = "address", cascade = CascadeType.PERSIST)
	private List<User> users;

	public Address() {
	}

	public Address(int id, String street1, String street2, String city, String state, String zipCode, boolean enabled,
			List<Event> events, List<User> users) {
		super();
		this.id = id;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.state = state;
		this.zipCode = zipCode;
		this.enabled = enabled;
		this.events = events;
		this.users = users;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getStreet1() {
		return street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	public String getStreet2() {
		return street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}

	public boolean isEnabled() {
		return enabled;
	}

	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<Event> getEvents() {
		return events;
	}

	public void setEvents(List<Event> events) {
		this.events = events;
	}

	public List<User> getUsers() {
		return users;
	}

	public void setUsers(List<User> users) {
		this.users = users;
	}

	public void addEvent(Event event) {
		if (events == null) {
			events = new ArrayList<>();
		}
		if (!events.contains(event)) {
			events.add(event);
			if (event.getAddress() != null) {
				event.getAddress().getEvents().remove(event);
			}
			event.setAddress(this);
		}
	}

	public void removeEvent(Event event) {
		event.setAddress(null);
		if (events != null) {
			events.remove(event);
		}
	}

	public void addUser(User user) {
		if (users == null) {
			users = new ArrayList<>();
		}
		if (!users.contains(user)) {
			users.add(user);
			if (user.getAddress() != null) {
				user.getAddress().getUsers().remove(user);
			}
			user.setAddress(this);
		}
	}

	public void removeUser(User user) {
		user.setAddress(null);
		if (users != null) {
			users.remove(user);
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
		Address other = (Address) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Address [id=");
		builder.append(id);
		builder.append(", street1=");
		builder.append(street1);
		builder.append(", street2=");
		builder.append(street2);
		builder.append(", city=");
		builder.append(city);
		builder.append(", state=");
		builder.append(state);
		builder.append(", zipCode=");
		builder.append(zipCode);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append("]");
		return builder.toString();
	}

}
