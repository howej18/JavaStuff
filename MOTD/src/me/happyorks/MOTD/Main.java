package me.happyorks.MOTD;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent e){
		Player player = e.getPlayer();
		player.sendMessage(ChatColor.GREEN + getConfig().getString("message"));
	}
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		getConfig().options().copyDefaults(true);
		saveConfig();
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String commandLabel, String[] args){
		if(commandLabel.equalsIgnoreCase("motd")){
			sender.sendMessage(ChatColor.GREEN + "MOTD: " + getConfig().getString("message"));
		}
		
		if(commandLabel.equalsIgnoreCase("setmotd")){
			if(!sender.hasPermission("motd.set")){
				sender.sendMessage(ChatColor.RED + "YOU DO NOT HAVE PERMISSION TO DO THIS!");
				return true;
			}
			if(args.length == 0){
				sender.sendMessage(ChatColor.DARK_RED + "Please specify a message");
				return true;
			}
			StringBuilder str = new StringBuilder();
			for(int i = 0; i<args.length;i++){
				str.append(args[i] + " ");
			}
			String motd = str.toString();
			getConfig().set("message", motd);
			saveConfig();
			sender.sendMessage(ChatColor.GREEN + "MOTD set to: " + motd);
		}
		return false;
	}
	
}
