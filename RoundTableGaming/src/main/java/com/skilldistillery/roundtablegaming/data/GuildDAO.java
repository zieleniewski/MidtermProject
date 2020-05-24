package com.skilldistillery.roundtablegaming.data;

import java.util.List;

import com.skilldistillery.roundtablegaming.entities.Guild;

public interface GuildDAO {
	
	public Guild create(Guild guild);
	
	public Guild update(Guild guild);
	
	public Guild enable(Guild guild);
	
	public Guild disable(Guild guild);
	
	public List<Guild> getAllGuilds();
	
	public Guild findGuildById(int id);
	
	public List<Guild> findGuildsByKeyword(String keyword);

}
