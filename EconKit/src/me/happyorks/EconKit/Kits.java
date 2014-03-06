package me.happyorks.EconKit;

import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;

public class Kits implements CommandExecutor {
	
	public EconKitMain plugin;
	
	public Kits(EconKitMain instance){
		plugin = instance;
	}

	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
		if (!(sender instanceof Player)) {
			sender.sendMessage(ChatColor.RED + "Only players can get kits!");
			return true;
		}

		Player p = (Player) sender;
		PlayerInventory pi = p.getInventory();

		if (cmd.getName().equalsIgnoreCase("kit")) {
			if(args.length == 0){
				p.sendMessage(ChatColor.AQUA + "[BASIC]: " + ChatColor.DARK_PURPLE + "Wood Pickaxe, Wood Axe, Wood Sword, 5 Apples");
				p.sendMessage(ChatColor.AQUA + "[STONE]: " + ChatColor.DARK_PURPLE + "Stone Pickaxe, Stone Axe, Stone Sword, 2 Mushroom Stew");
				p.sendMessage(ChatColor.AQUA + "[IRON]: " + ChatColor.DARK_PURPLE + "Iron Pickaxe, Iron Axe, Iron Sword, 2 Mushroom Stew");
				p.sendMessage(ChatColor.AQUA + "[IRON ARMOR]: " + ChatColor.DARK_PURPLE + "Complete set of Iron Armor");
				p.sendMessage(ChatColor.AQUA + "[DIAMOND]: " + ChatColor.DARK_PURPLE + "Diamond Pickaxe, Diamond Axe, Diamond Sword, 2 Mushroom Stew");
				p.sendMessage(ChatColor.AQUA + "[DIAMOND ARMOR]: " + ChatColor.DARK_PURPLE + "Complete set of Diamond Armor");
				p.sendMessage(ChatColor.AQUA + "[RANGER]: " + ChatColor.DARK_PURPLE + "Complete set of leather armor, Bow, 32 Arrows, 3 Apples");	
			}

		}
		
		if(cmd.getName().equalsIgnoreCase("kitbasic")){
			EconomyResponse r = EconKitMain.econ.withdrawPlayer(p.getName(), 10);
			if (r.transactionSuccess()) {
				pi.addItem(new ItemStack(Material.WOOD_PICKAXE, 1));
				pi.addItem(new ItemStack(Material.WOOD_AXE, 1));
				pi.addItem(new ItemStack(Material.WOOD_SWORD, 1));
				pi.addItem(new ItemStack(Material.APPLE, 5));
				p.sendMessage(ChatColor.GREEN + "You got your kit!");
				p.sendMessage(ChatColor.GREEN + "You balance is now " 
						+ ChatColor.BOLD + ChatColor.DARK_AQUA + EconKitMain.econ.getBalance(p.getName()));
				return true;
			} else {
				p.sendMessage(ChatColor.RED + "You cannot get a kit at this time!");
				return true;
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("kitstone")){
			EconomyResponse r = EconKitMain.econ.withdrawPlayer(p.getName(), 10);
			if (r.transactionSuccess()) {
				pi.addItem(new ItemStack(Material.STONE_PICKAXE, 1));
				pi.addItem(new ItemStack(Material.STONE_AXE, 1));
				pi.addItem(new ItemStack(Material.STONE_SWORD, 1));
				pi.addItem(new ItemStack(Material.MUSHROOM_SOUP, 2));
				p.sendMessage(ChatColor.GREEN + "You got your kit!");
				p.sendMessage(ChatColor.GREEN + "You balance is now "
						+ ChatColor.BOLD + ChatColor.DARK_AQUA + EconKitMain.econ.getBalance(p.getName()));
				return true;
			} else {
				p.sendMessage(ChatColor.RED + "You cannot get a kit at this time!");
				return true;
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("kitiron")){
			EconomyResponse r = EconKitMain.econ.withdrawPlayer(p.getName(), 10);
			if (r.transactionSuccess()) {
				pi.addItem(new ItemStack(Material.IRON_PICKAXE, 1));
				pi.addItem(new ItemStack(Material.IRON_AXE, 1));
				pi.addItem(new ItemStack(Material.IRON_SWORD, 1));
				pi.addItem(new ItemStack(Material.MUSHROOM_SOUP, 2));
				p.sendMessage(ChatColor.GREEN + "You got your kit!");
				p.sendMessage(ChatColor.GREEN + "You balance is now "
						+ ChatColor.BOLD + ChatColor.DARK_AQUA + EconKitMain.econ.getBalance(p.getName()));
				return true;
			} else {
				p.sendMessage(ChatColor.RED + "You cannot get a kit at this time!");
				return true;
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("kitironarmor")){
			EconomyResponse r1 = EconKitMain.econ.withdrawPlayer(p.getName(), 10);
			if (r1.transactionSuccess()) {
				pi.addItem(new ItemStack(Material.IRON_HELMET, 1));
				pi.addItem(new ItemStack(Material.IRON_CHESTPLATE, 1));
				pi.addItem(new ItemStack(Material.IRON_LEGGINGS, 1));
				pi.addItem(new ItemStack(Material.IRON_BOOTS, 1));
				p.sendMessage(ChatColor.GREEN + "You got your kit!");
				p.sendMessage(ChatColor.GREEN + "You balance is now "
						+ ChatColor.BOLD + ChatColor.DARK_AQUA + EconKitMain.econ.getBalance(p.getName()));
				return true;
			} else {
				p.sendMessage(ChatColor.RED
						+ "You cannot get a kit at this time!");
				return true;
			}
		}
		

		if(cmd.getName().equalsIgnoreCase("kitdiamond")){
			EconomyResponse r2 = EconKitMain.econ.withdrawPlayer(p.getName(), 10);
			if (r2.transactionSuccess()) {
				pi.addItem(new ItemStack(Material.DIAMOND_PICKAXE, 1));
				pi.addItem(new ItemStack(Material.DIAMOND_AXE, 1));
				pi.addItem(new ItemStack(Material.DIAMOND_SWORD, 1));
				pi.addItem(new ItemStack(Material.MUSHROOM_SOUP, 2));
				p.sendMessage(ChatColor.GREEN + "You got your kit!");
				p.sendMessage(ChatColor.GREEN + "You balance is now "
						+ ChatColor.BOLD + ChatColor.DARK_AQUA + EconKitMain.econ.getBalance(p.getName()));
				return true;
			} else {
				p.sendMessage(ChatColor.RED
						+ "You cannot get a kit at this time!");
				return true;
			}
		}
		

		if(cmd.getName().equalsIgnoreCase("kitdiamondarmor")){
			EconomyResponse r3 = EconKitMain.econ.withdrawPlayer(p.getName(), 10);
			if (r3.transactionSuccess()) {
				pi.addItem(new ItemStack(Material.DIAMOND_HELMET, 1));
				pi.addItem(new ItemStack(Material.DIAMOND_CHESTPLATE, 1));
				pi.addItem(new ItemStack(Material.DIAMOND_LEGGINGS, 1));
				pi.addItem(new ItemStack(Material.DIAMOND_BOOTS, 1));
				p.sendMessage(ChatColor.GREEN + "You got your kit!");
				p.sendMessage(ChatColor.GREEN + "You balance is now "
						+ ChatColor.BOLD + ChatColor.DARK_AQUA + EconKitMain.econ.getBalance(p.getName()));
				return true;
			} else {
				p.sendMessage(ChatColor.RED
						+ "You cannot get a kit at this time!");
				return true;
			}
		}
		

		if(cmd.getName().equalsIgnoreCase("kitranger")){
			EconomyResponse r2 = EconKitMain.econ.withdrawPlayer(p.getName(), 10);
			if (r2.transactionSuccess()) {
				pi.addItem(new ItemStack(Material.BOW, 1));
				pi.addItem(new ItemStack(Material.ARROW, 32));
				pi.addItem(new ItemStack(Material.LEATHER_HELMET, 1));
				pi.addItem(new ItemStack(Material.LEATHER_CHESTPLATE, 1));
				pi.addItem(new ItemStack(Material.LEATHER_LEGGINGS, 1));
				pi.addItem(new ItemStack(Material.LEATHER_BOOTS, 1));
				p.sendMessage(ChatColor.GREEN + "You got your kit!");
				p.sendMessage(ChatColor.GREEN + "You balance is now "
						+ ChatColor.BOLD + ChatColor.DARK_AQUA + EconKitMain.econ.getBalance(p.getName()));
				return true;
			} else {
				p.sendMessage(ChatColor.RED
						+ "You cannot get a kit at this time!");
				return true;

			}
		}
		if(cmd.getName().equalsIgnoreCase("ci")){
			pi.clear();
			p.sendMessage(ChatColor.RED + "Inventory Cleared!");
		}
		return false;
	}
	
}
