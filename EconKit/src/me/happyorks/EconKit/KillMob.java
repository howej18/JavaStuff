package me.happyorks.EconKit;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.entity.Zombie;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDeathEvent;

public class KillMob implements Listener {

	public static Economy econ = null;

	
	public void onEntityDeath(EntityDeathEvent event) {
		Entity e = event.getEntity();
		if (e.getLastDamageCause() instanceof EntityDamageByEntityEvent) {
			EntityDamageByEntityEvent nEvent = (EntityDamageByEntityEvent) e.getLastDamageCause();
			if (nEvent.getDamager() instanceof Player) {
				Player p = (Player) nEvent.getDamager();
				String playername = p.getName();
				p.sendMessage(ChatColor.GOLD + "You killed " + e);
				econ.depositPlayer(playername, 10.0);
				p.sendMessage(ChatColor.GREEN + "Your balance is now " + econ.getBalance(playername));
			}
		}
	}

}
