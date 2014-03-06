package me.happyorks.EconKit;

import net.milkbowl.vault.economy.Economy;

import org.bukkit.event.Listener;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class EconKitMain extends JavaPlugin implements Listener {

	public static Economy econ = null;
	
	public void onEnable() {
		
		getCommand("kit").setExecutor(new Kits(this));
		getCommand("kitbasic").setExecutor(new Kits(this));
		getCommand("kitstone").setExecutor(new Kits(this));
		getCommand("kitiron").setExecutor(new Kits(this));
		getCommand("kitironarmor").setExecutor(new Kits(this));
		getCommand("kitdiamond").setExecutor(new Kits(this));
		getCommand("kitdiamondarmor").setExecutor(new Kits(this));
		getCommand("kitranger").setExecutor(new Kits(this));
		getCommand("ci").setExecutor(new Kits(this));
		getCommand("sell").setExecutor(new Sell(this));
		getCommand("store").setExecutor(new Store(this));

		
		if (!setupEconomy()) {
			getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
			getServer().getPluginManager().disablePlugin(this);
			return;
		}
	}

	private boolean setupEconomy() {
		
		if (getServer().getPluginManager().getPlugin("Vault") == null) {
			return false;
		}
		RegisteredServiceProvider<Economy> rsp = getServer()
				.getServicesManager().getRegistration(Economy.class);
		if (rsp == null) {
			return false;
		}
		econ = rsp.getProvider();
		return econ != null;
	}

	
	
}









