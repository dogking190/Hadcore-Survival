package com.gmail.dogking190;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.server.ServerCommandEvent;

public class CommandCancel implements Listener {

	HLM plugin;
	
	public CommandCancel(HLM instance){
		plugin = instance;
	}
	
	@EventHandler
	public void ConsoleCommandCancel(ServerCommandEvent event){
		
		String CC = event.getCommand();
		if(CC.contains("gamemode")){
			event.setCommand("/gamemode");
		}
		if(CC.contains("op")){
			event.setCommand("op");
		}
	}
}
