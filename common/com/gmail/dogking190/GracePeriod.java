package com.gmail.dogking190;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerJoinEvent;

public class GracePeriod implements Listener {

	HLM plugin;
	public int count = 300;

	public GracePeriod(HLM instance) {
		plugin = instance;
	}

	@EventHandler
	public void gracePeriods(PlayerJoinEvent event) {
		final Player player = event.getPlayer();

		final String p = player.getName();
		if (player.hasPlayedBefore() == false) {
			plugin.m.sendMessage(player,
					" Grace Period is Active for 5mins You take no damage. Use this time Wisely");
			

			plugin.Grace.add(p);

			plugin.getServer().getScheduler()
					.scheduleSyncRepeatingTask(plugin, new Runnable() {

						public void run() {
							if (count != -1) {
								if (count != 0) {

									if (count == 150) {
										plugin.m.sendMessage(player,
												" You Have 2 mins 30 seconds Left!");
									}

									if (count == 60) {
										plugin.m.sendMessage(player,
												" You Have 1 min Left!");
									}

									if (count == 10) {
										plugin.m.sendMessage(player,
												" You Have 10 seconds Left!");
									}

									count--;
								}
								if (count == 0) {

									plugin.m.sendMessage(player,
											" Grace Period Over!");
									
									plugin.Grace.remove(p);

									count--;
								}
							}

						}
					}, 0L, 20L);

			// 60 L == 3 sec, 20 ticks == 1 sec
		}
	}

	@EventHandler
	public void noDamage(EntityDamageEvent event) {

		Entity entity = event.getEntity();
		if (entity instanceof Player) {
			Player player = (Player) event.getEntity();

			String p = player.getName();

			if (plugin.Grace.contains(p) == true) {

				event.setCancelled(true);

			}
		}
	}
}
