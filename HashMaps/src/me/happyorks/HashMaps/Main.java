package me.happyorks.HashMaps;

import java.util.HashMap;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerPickupItemEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	HashMap<String, Integer> hm = new HashMap<String, Integer>();
	
	public void onEnable(){
		Bukkit.getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler(priority = EventPriority.MONITOR)
	public void onPlayerPickupItem(PlayerPickupItemEvent e){
		Player pu = e.getPlayer();
		String name = pu.getName();
		if(hm.containsKey(name)){
			int n = hm.get(name);
			int n2 = n + 1;
			hm.put(name, n2);
			pu.sendMessage("You have picked up " + n2 + " ItemStacks");
		}else{
			int n = 1;
			hm.put(name, n);
			pu.sendMessage("You have picked up 1 ItemStack");
			
		}
	}
	
}
