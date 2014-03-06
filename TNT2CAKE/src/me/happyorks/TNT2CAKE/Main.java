package me.happyorks.TNT2CAKE;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public static Material[] banList = { Material.TNT };

	public void onEnable() {
		PluginManager pm = Bukkit.getPluginManager();
		pm.registerEvents(this, this);
	}

	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event) {
		Material block = event.getBlock().getType();
		Player player = event.getPlayer();

		for (Material blocked : banList) {
			if (blocked == block) {
				if (player.isOp()) {
					// NOTHING - LET IT GET PLACED!
				} else {
					event.getBlock().setType(Material.CAKE_BLOCK);
					player.sendMessage(ChatColor.RED + "[TNT2CAKE]"
							+ ChatColor.DARK_RED
							+ "YOU ARE NOT PERMITTED TO PLACE TNT!");
				}
			}

		}
	}

}