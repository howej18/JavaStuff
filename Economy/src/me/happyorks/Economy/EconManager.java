package me.happyorks.Economy;

import java.util.HashMap;

public class EconManager {
	
	private static SmallEconomy plugin;
	public EconManager(SmallEconomy instance){
		plugin = instance;
	}

	public static HashMap<String, Double> bal = new HashMap<String, Double>(); // {PlayerName, Balance}
	
	public static void setBalance(String player, double amount){
		bal.put(player, amount);
	}
	
	public static Double getBalance(String player){
		return bal.get(player);
	}
	
	public static boolean hasAccount(String player){
		return bal.containsKey(player);
	}
	
	public static HashMap<String, Double> getBalanceMap(){
		return bal;
	}
	
	public static SmallEconomy getPlugin(){
		return plugin;
	}
}
