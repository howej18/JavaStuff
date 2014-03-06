package me.hapyorks.Lightning;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onPlayerInteractBlock(PlayerInteractEvent event) {
	    Player player = event.getPlayer();
	    if (player.getItemInHand().getType() == Material.FISHING_ROD) {
	    // Creates a bolt of lightning at a given location. In this case, that location is where the player is looking.
	    // Can only create lightning up to 200 blocks away.
	    player.getWorld().strikeLightning(player.get(null, 200).getLocation());
	    }
	}

}
