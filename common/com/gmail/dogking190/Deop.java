package com.gmail.dogking190;

import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class Deop implements Listener {
	HLM plugin;
	
	public Deop(HLM instance){
		plugin = instance;
	}
	
	@EventHandler
	public void Deoper(PlayerJoinEvent event){
		Player player = event.getPlayer();
		if(player.isOp()){
			plugin.m.sendMessage(player, "No Ops!");
			player.setOp(false);
		}
	}
}
