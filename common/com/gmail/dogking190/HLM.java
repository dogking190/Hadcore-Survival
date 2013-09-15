package com.gmail.dogking190;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.World;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class HLM extends JavaPlugin{
	
	static final Logger logger = Logger.getLogger("Minecraft");
	public final Methods m = new Methods();
	
	public ArrayList<String> Grace = new ArrayList<>();
	
	public void onEnable(){
		
		logger.info("[Hardcore Survival] Enabled");
		
		PluginManager pm = getServer().getPluginManager();
		
		
		pm.registerEvents(new BiggerCreeper(this), this);
		pm.registerEvents(new GracePeriod(this), this);
		//pm.registerEvents(new CommandCancel(this), this);
		//pm.registerEvents(new Deop(this), this);
		
		/**---------------------------- Config File--------------------------------------- */
		FileConfiguration config = this.getConfig();
		
		saveDefaultConfig();
		/**---------------------------- Config File End--------------------------------- */
				
		if(config.getBoolean("Time.AlwaysNight")){
			
			/** --------------------- Bukkit Runnable---------------------------------------- */
			
			Bukkit.getServer().getScheduler().scheduleSyncRepeatingTask(this, new Runnable(){
			 
			@Override
			public void run() {
			for(World w : Bukkit.getServer().getWorlds()){
			if(w.getTime() < 20000){
				w.setTime(20000);
			}
					}
				}
			}, 0L, 20);
			
			/** --------------------------- Bukkit Runable End ------------------------------------- */
			
		}
	}
	
	
	public void onDisable(){
		logger.info("[Hardcore Survival] Disabled");
	}
}
