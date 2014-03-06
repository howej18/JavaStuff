package me.happyorks.recipes;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {
	
	public void onEnable(){
		ShapedRecipe disk = new ShapedRecipe(new ItemStack(Material.RECORD_12));
		disk.shape(new String[]{"###","#*#","###"}).setIngredient('#', Material.WOOD).setIngredient('*', Material.LAPIS_BLOCK);
		Bukkit.getServer().addRecipe(disk);
	}
	
	public void onDisable(){
		Bukkit.getServer().clearRecipes();
	}

}
