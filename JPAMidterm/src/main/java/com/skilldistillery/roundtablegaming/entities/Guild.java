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
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Guild {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	private String description;
	@Column(name = "logo_url")
	private String logoURL;
	@ManyToMany(cascade = CascadeType.PERSIST)
	@JoinTable(name = "guild_member",
			joinColumns = @JoinColumn(name = "guild_id"),
			inverseJoinColumns = @JoinColumn(name = "user_id"))
	private boolean enabled;
	private List<User> members;
	
	public Guild() {}

	public Guild(int id, String name, String description, String logoURL, boolean enabled, List<User> members) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.logoURL = logoURL;
		this.enabled = enabled;
		this.members = members;
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

	public String getLogoURL() {
		return logoURL;
	}

	public void setLogoURL(String logoURL) {
		this.logoURL = logoURL;
	}

	public boolean isEnabled() {
		return enabled;
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
	}

	public List<User> getMembers() {
		return members;
	}

	public void setMembers(List<User> members) {
		this.members = members;
	}

	public void addMember(User member) {
		if (members == null) {
			members = new ArrayList<>();
		}
		if (!members.contains(member)) {
			members.add(member);
			member.addGuild(this);
		}
	}
	
	public void removeMember(User member) {
		if (member != null && members.contains(member)) {
			members.remove(member);
			member.removeGuild(this);
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
		Guild other = (Guild) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Guild [id=");
		builder.append(id);
		builder.append(", name=");
		builder.append(name);
		builder.append(", description=");
		builder.append(description);
		builder.append(", logoURL=");
		builder.append(logoURL);
		builder.append(", enabled=");
		builder.append(enabled);
		builder.append("]");
		return builder.toString();
	}

}
