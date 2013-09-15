package com.gmail.dogking190;

import org.bukkit.entity.Creeper;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityExplodeEvent;

public class BiggerCreeper implements Listener {

	HLM plugin;

	public BiggerCreeper(HLM instance) {
		plugin = instance;
	}

	@EventHandler
	public void onEntityExplode(EntityExplodeEvent event) {

		if (event.getEntity() instanceof Creeper) {
			float explosionPower = 20;
			event.setCancelled(true);
			event.getLocation().getWorld().createExplosion(event.getLocation(), explosionPower);
		}
	}

}
