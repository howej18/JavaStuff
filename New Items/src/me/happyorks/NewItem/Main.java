package me.happyorks.NewItem;

import java.util.Arrays;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args){
		if(label.equalsIgnoreCase("coolnewitem")){
			ItemStack newItem = setMeta(new ItemStack(Material.DIRT), ChatColor.RED + "COOL DIRT", Arrays.asList("First line of dirt" , "second line of dirt"));
			((Player)sender).getInventory().addItem(newItem);
		}
		if(label.equalsIgnoreCase("coolnewboots")){
			ItemStack newBoots = new dyeArmor(Material.LEATHER_BOOTS, 0, 153, 255);
			((Player)sender).getInventory().setBoots(newBoots);
		}
		return false;
	}
	
	public ItemStack dyeArmor(Material material, int r, int g, int b){
		ItemStack armor = new ItemStack(material);
		LeatherArmorMeta lam = (LeatherArmorMeta) armor.getItemMeta();
		
		lam.setColor(Color.fromRGB(r,g,b));
		armor.setItemMeta(lam);
		
		return armor;
	}
	
	
	public ItemStack setMeta(ItemStack material, String name, List<String> lore){
		if(((material == null) || material.getType() == Material.AIR)
			|| ((name == null) && lore == null))
		return null;
		
		ItemMeta im = material.getItemMeta();
		if(name != null){
			im.setDisplayName(name);
		}
		if(lore != null){
			im.setLore(lore);
		}
		material.setItemMeta(im);
		return material;
	}
}
