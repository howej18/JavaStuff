package me.happyorks.FallingBlocks;


import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public void onEnable(){
	Bukkit.getServer().getPluginManager().registerEvents(this, this);
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
	public void onBlockPlace(BlockPlaceEvent event){
		if(event.getBlock().getLocation().subtract(0, 1, 0).getBlock().getType()!=Material.AIR)
		return;
		
		event.getBlock().getWorld().spawnFallingBlock(event.getBlock().getLocation(), event.getBlock().getType(), event.getBlock().getData());
		event.getBlock().setType(Material.AIR);
	}
}
