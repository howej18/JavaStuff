package me.happyorks.Kit;

import net.milkbowl.vault.economy.Economy;
import net.milkbowl.vault.economy.EconomyResponse;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.plugin.RegisteredServiceProvider;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin {

	public static Economy econ = null;
	
	public void onEnable() {
        if (!setupEconomy() ) {
            getLogger().severe(String.format("[%s] - Disabled due to no Vault dependency found!", getDescription().getName()));
            getServer().getPluginManager().disablePlugin(this);
            return;
        }
    }
	
	private boolean setupEconomy() {
        if (getServer().getPluginManager().getPlugin("Vault") == null) {
            return false;
        }
        RegisteredServiceProvider<Economy> rsp = getServer().getServicesManager().getRegistration(Economy.class);
        if (rsp == null) {
            return false;
        }
        econ = rsp.getProvider();
        return econ != null;
    }
	
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args){
		if(!(sender instanceof Player)){
			sender.sendMessage(ChatColor.RED + "Only players can get kits!");
			return true;
		}
		
		Player p = (Player) sender;
		PlayerInventory pi = p.getInventory();
		
		if(cmd.getName().equalsIgnoreCase("kit")){
			EconomyResponse r = econ.withdrawPlayer(p.getName(), 10);
			if(r.transactionSuccess()){
				pi.addItem(new ItemStack(Material.STONE_SWORD, 1));
				pi.addItem(new ItemStack(Material.STONE_PICKAXE, 1));
				pi.addItem(new ItemStack(Material.APPLE, 5));
				p.sendMessage(ChatColor.GREEN + "You got your kit!");
				p.sendMessage(ChatColor.GREEN + "You balance is now " + econ.getBalance(p.getName()));
				return true;
			}else{
				p.sendMessage(ChatColor.DARK_RED + "You cannot get a kit at this time!");
				return true;
			}
		}
		
		if(cmd.getName().equalsIgnoreCase("ci")){
			pi.clear();
			p.sendMessage(ChatColor.GREEN + "Inventory cleared!");
		}
		return true;
	}
	
}
