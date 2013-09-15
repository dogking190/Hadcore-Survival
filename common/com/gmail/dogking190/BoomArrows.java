package com.gmail.dogking190;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Arrow;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Skeleton;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.ProjectileHitEvent;

public class BoomArrows implements Listener {
	HLM plugin;
	
	public BoomArrows(HLM instance){
		plugin = instance;
	}
	
	@EventHandler
	public void ArrowContact(ProjectileHitEvent event){
		
		Entity entity = event.getEntity();
		
		if(entity instanceof Arrow){
			Arrow arrow = (Arrow) entity;
			Entity shooter = arrow.getShooter();
			if(shooter instanceof Skeleton){
				Location loc = arrow.getLocation();
				World w = loc.getWorld();
				
				w.createExplosion(loc, 2F);
			}
		}
		
	}
}
