package me.happyorks.Rater;

import java.util.logging.Logger;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Rater extends JavaPlugin {
	public static Rater plugin;
	public final Logger logger = Logger.getLogger("Minecraft");
	int counter = 0;
	
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
	
		if(commandLabel.equalsIgnoreCase("rateme")){
			if(args.length == 0){
				if(player.isOp()){
					player.sendMessage("----" + ChatColor.GREEN + "RateMe Help (Admin)" + ChatColor.WHITE + "----");
					player.sendMessage(ChatColor.AQUA + "/RateMe" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows This Screen");
					player.sendMessage(ChatColor.AQUA + "/RateMe <Admin's Name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Sends a message to an Admin for a RateMe request");
					player.sendMessage(ChatColor.AQUA + "/RateMe Left" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows the ammount of Rates left to be completed");
					player.sendMessage(ChatColor.AQUA + "/RateMe Done" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Finishes the RateMe request");
				}else{
					player.sendMessage("----" + ChatColor.GREEN + "RateMe Help" + ChatColor.WHITE + "----");
					player.sendMessage(ChatColor.AQUA + "/RateMe" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Shows This Screen");
					player.sendMessage(ChatColor.AQUA + "/RateMe <Admin's Name>" + ChatColor.WHITE + " | " + ChatColor.GREEN + "Sends a message to an Admin for a RateMe request");
				}
			}if(args.length == 1){
				if(player.getServer().getPlayer(args[0]) !=null){
					Player targetPlayer = player.getServer().getPlayer(args[0]);
					if(targetPlayer.isOp()){
						counter++;
						targetPlayer.sendMessage(ChatColor.GREEN + "You have a RateMe request from " + ChatColor.DARK_AQUA + player.getName());
						targetPlayer.sendMessage(ChatColor.GREEN + "There are now " + counter + "RateMe requests to complete");
						targetPlayer.sendMessage(ChatColor.DARK_GREEN + "REMEMBER! Use " + ChatColor.GOLD + "/RateMe Done" + ChatColor.DARK_GREEN + "When you have finished");
					}else{
						player.sendMessage(ChatColor.DARK_RED + "That player is not an Admin!");
					}
				}if(player.isOp()){
					if(args[0].equalsIgnoreCase("left")){
						if(counter == 0){
							player.sendMessage(ChatColor.GREEN + "There are no RateME requests at the moment!");
						}else if(counter == 1){
							player.sendMessage(ChatColor.AQUA + "There is 1 RateMe request at the moment!");
						}else{
							player.sendMessage(ChatColor.AQUA + "There are " + counter + " RateMe requests at the moment");
						}
					}else if(args[0].equalsIgnoreCase("done")){
						if(counter <= 0){
							player.sendMessage(ChatColor.DARK_RED + "There are no rates to complete!");
						}else{
							counter--;
							if(counter == 0){
								player.sendMessage(ChatColor.LIGHT_PURPLE + "Rate Completed! There are 0 RateMe requests left to do");
							}else if(counter == 1){
								player.sendMessage(ChatColor.LIGHT_PURPLE + "Rate Completed! There is 1 RateMe requests left to do");
							}else{
								player.sendMessage(ChatColor.LIGHT_PURPLE + "Rate Completed! There are " + counter +  "RateMe requests left to do");

							}
						}
					}
				}else{
					player.sendMessage(ChatColor.DARK_RED + "You do not have the permissions to do this!");
				}
			}
		}
		return false;
	}
}
	
							