package me.happyorks.Economy;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class EconCommand implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args) {
		
		if(args.length != 3){
			sender.sendMessage(ChatColor.RED + "Not enough arguments!");
			sender.sendMessage(ChatColor.GREEN + "Usage: /econ <add/remove/set> <player> <amount>");
			return true;
		}
		
		if(args[0].equalsIgnoreCase("add")){
			if(EconManager.hasAccount(args[1])){
				sender.sendMessage(ChatColor.RED + "Player does not have an account!");
				return true;
			}
			double amount = 0;
			try{
				amount = Double.parseDouble(args[2]);
			}catch(Exception e){
				sender.sendMessage(ChatColor.RED + "You must enter a number!");
				return true;
			}
			
			EconManager.setBalance(args[1], EconManager.getBalance(args[1]) + amount);
			
		}else if(args[0].equalsIgnoreCase("remove")){
			if(EconManager.hasAccount(args[1])){
				sender.sendMessage(ChatColor.RED + "Player does not have an account!");
				return true;
			}
			double amount = 0;
			try{
				amount = Double.parseDouble(args[2]);
			}catch(Exception e){
				sender.sendMessage(ChatColor.RED + "You must enter a number!");
				return true;
			}
			
			EconManager.setBalance(args[1], EconManager.getBalance(args[1]) - amount);
			
		}else if(args[0].equalsIgnoreCase("set")){
			if(EconManager.hasAccount(args[1])){
				sender.sendMessage(ChatColor.RED + "Player does not have an account!");
				return true;
			}
			double amount = 0;
			try{
				amount = Double.parseDouble(args[2]);
			}catch(Exception e){
				sender.sendMessage(ChatColor.RED + "You must enter a number!");
				return true;
			}
			
			EconManager.setBalance(args[1], amount);
		}else{
			sender.sendMessage(ChatColor.RED + "Incorrect argument/s!");
		}
		return true;
	}

	
	
}
