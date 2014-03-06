package me.happyorks.DeathDrops;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.entity.Sheep;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.event.entity.PlayerDeathEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@EventHandler
	public void onPlayerDeath(PlayerDeathEvent e){
		e.setDroppedExp(1);
		
		e.getDrops().clear();
		e.getDrops().add(new ItemStack(Material.GOLD_INGOT, 5));
	}
	
	@EventHandler
	public void onEntityDeath(EntityDeathEvent e){
		if(e.getEntity() instanceof Sheep){
			e.getEntity().getWorld().dropItem(e.getEntity().getLocation(), new ItemStack(Material.SHEARS, 1));

		}
	}
}
