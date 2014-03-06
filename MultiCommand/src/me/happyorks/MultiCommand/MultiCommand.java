package me.happyorks.MultiCommand;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Location;
import org.bukkit.World;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Event;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public class MultiCommand extends JavaPlugin {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static MultiCommand plugin;
	
	
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled!");
	}
	
	public void onEnable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " has been enabled!");
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		Player player = (Player) sender;
		World world = player.getWorld();
		
		if(commandLabel.equalsIgnoreCase("time")){
			if(args[0].equalsIgnoreCase("day")){
				world.setTime(0);
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "Time set to day!");
			}else if(args[0].equalsIgnoreCase("night")){
				world.setTime(18000);
				Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "Time set to night!");
			}
		}
		
		if(commandLabel.equalsIgnoreCase("heal") || commandLabel.equalsIgnoreCase("h")){
			if(args.length == 0){ 
				// /heal = 0 args /heal happyorks = 1 args
				player.setHealth(20.0); 
				player.setFireTicks(0);
				player.sendMessage(ChatColor.GREEN + "Healed!");
			}else if(args.length == 1){
				if(player.getServer().getPlayer(args[0]) != null){
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				targetPlayer.setHealth(20.0);
				targetPlayer.setFireTicks(0);
				player.sendMessage(ChatColor.GREEN + "Healed!");
				}else{
					player.sendMessage(ChatColor.RED + "Player not online!");
				}
			}
		}
		if(commandLabel.equalsIgnoreCase("jakeport")){
			if(args.length == 0){
				player.sendMessage(ChatColor.DARK_RED + "TOO FEW ARGUMENTS");
			}else if(args.length == 1){
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				Location targetPlayerLocation = targetPlayer.getLocation();
				player.teleport(targetPlayerLocation);
			}else if(args.length == 2){
				Player targetPlayer = player.getServer().getPlayer(args[0]);
				Player targetPlayer1 = player.getServer().getPlayer(args[1]);
				Location targetPlayer1Location = targetPlayer1.getLocation();
				targetPlayer.teleport(targetPlayer1Location);
				targetPlayer.sendMessage(ChatColor.RED + "You have been teleported to " + player.getDisplayName());
			}
		}
		return false;
	}
	
	
}
