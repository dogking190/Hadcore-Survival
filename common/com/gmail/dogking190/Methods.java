package com.gmail.dogking190;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class Methods {

	public void sendMessage(Player player, String s){
		player.sendMessage(ChatColor.BLACK + "[" + ChatColor.RED + "Hardcore Survival" + ChatColor.BLACK + "]" + " " + s);
	}
}
