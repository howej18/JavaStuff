package me.happyorks.Economy;

import org.bukkit.Bukkit;
import org.bukkit.plugin.java.JavaPlugin;

public class SmallEconomy extends JavaPlugin {
	
	public void onEnable(){
		getCommand("econ").setExecutor(new EconCommand());
		new EconManager(this);
		SLAPI.loadBalances();
		Bukkit.getPluginManager().registerEvents(new PlayerJoin(), this);
	}
	
	public void onDisable(){
		SLAPI.saveBalances();
	}

}
