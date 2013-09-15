package com.gmail.dogking190;

import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.entity.Entity;
import org.bukkit.entity.EntityType;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.EntityExplodeEvent;

public class BiggerCreeper implements Listener {

	HLM plugin;

	public BiggerCreeper(HLM instance) {
		plugin = instance;
	}

	@EventHandler
	public void CreeperExplode(EntityExplodeEvent event) {
		EntityType e = event.getEntity().getType();
		Location loc = event.getEntity().getLocation();
		World w = loc.getWorld();
		if (e == EntityType.CREEPER) {
			event.setCancelled(true);
			w.createExplosion(loc, 5);
			event.getEntity().remove();
			
		}
	}

	public void NewCreeperExplosion(EntityDeathEvent event) {
		if (event.getEntity() != null) {
			if (event.getEntityType() == EntityType.CREEPER) {
				Entity en = event.getEntity();
				Location loc = en.getLocation();
				World w = loc.getWorld();

				w.createExplosion(loc, 20F);
			}
		}
	}
}
