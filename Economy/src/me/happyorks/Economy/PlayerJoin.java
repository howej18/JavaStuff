package me.happyorks.Economy;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;

public class PlayerJoin implements Listener {

	@EventHandler
	public void onJoin(PlayerJoinEvent event){
		if(EconManager.hasAccount(event.getPlayer().getName())) return;
		EconManager.setBalance(event.getPlayer().getName(), 200D);
	}
}
