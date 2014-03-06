package me.happyorks.Nicknames;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Only players can have nicknames!");
			return true;
		}
		
		Player p = (Player) sender;
		
		if(cmd.getName().equalsIgnoreCase("nick")){
			if(args.length == 0){
				sender.sendMessage(ChatColor.RED + "You did not specify a nickname!");
				return true;
			}
			
			String nick = "";
			for(String arg : args){
				nick += arg + " ";
			}
			
			nick = nick.substring(0, nick.length() - 1);
			
			nick = nick.replaceAll("&", "¤");
			
			p.sendMessage(ChatColor.GREEN  + "You have changed your nickname to " + nick);
			this.getConfig().set(p.getName(), nick);
			this.saveConfig();
		}
		return true;
	}
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e){
		if(this.getConfig().getString(e.getPlayer().getName()) != null){
			e.getPlayer().setDisplayName(this.getConfig().getString(e.getPlayer().getName()) + ChatColor.RESET);
		}
	}
	
}








