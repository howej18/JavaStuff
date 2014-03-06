package me.happyorks.AntiSwear;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	@EventHandler

	public void onPlayerChat(AsyncPlayerChatEvent e){
		for(String word : e.getMessage().split(" ")){
			if(getConfig().getStringList("bannedwords").contains(word)){
				e.setCancelled(true);
				e.getPlayer().sendMessage(ChatColor.DARK_RED + "Please don't use that sort of language!");
			}
		}
	}
	
	public void onEnable(){
		getConfig().options().copyDefaults(true);
		saveConfig();
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}

}
