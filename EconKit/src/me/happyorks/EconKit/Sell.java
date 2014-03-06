package me.happyorks.EconKit;


import net.milkbowl.vault.economy.Economy;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.RegisteredServiceProvider;

public class Sell implements CommandExecutor {
	
	public EconKitMain plugin;
	public static Economy econ = null;
	
	public Sell(EconKitMain instance){
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
		Player p = (Player) sender;
		PlayerInventory pi = p.getInventory();
		ItemStack is = new ItemStack(Material.AIR);
		String pname = p.getName();
		
		
		if(cmd.getName().equalsIgnoreCase("sell")){
			if (!(sender instanceof Player)){
				sender.sendMessage(ChatColor.DARK_RED  + "Only players can sell items!");
			}
			if(pi.getItemInHand() == null){
				p.sendMessage(ChatColor.DARK_RED + "You must be holding an item to sell it!");
			}
			if(pi.getItemInHand() == Material.DIAMOND){
				int diamondamt = pi.getItemInHand().getAmount();
				int diamondprice = diamondamt * 10;
				pi.setItemInHand(is);
				p.sendMessage(ChatColor.GOLD + "You sold " + diamondamt + "diamonds");
				econ.depositPlayer(pname, diamondprice);
				//p.sendMessage(diamondprice + ChatColor.GOLD + "has been added to your account!");
				p.sendMessage(ChatColor.GOLD + "Your balance is now " + ChatColor.RESET + econ.getBalance(pname));
			}
		}
		return false;
	}

}
