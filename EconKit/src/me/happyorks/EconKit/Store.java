package me.happyorks.EconKit;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class Store implements CommandExecutor {

public EconKitMain plugin;
	
	public Store(EconKitMain instance){
		plugin = instance;
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args){
		if(cmd.getName().equalsIgnoreCase("store")){
			
		}
		return false;
		
	}
	
}
