package me.happyorks.BigBoom;

import net.minecraft.server.v1_6_R3.Material;

import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener{
	
	public void blockEvent(BlockEvent event){
		if(event.getBlock() == Material.TNT){
			
		}
	}

}
