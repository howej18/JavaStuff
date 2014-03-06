package me.happyorks.Timer;

import org.bukkit.Bukkit;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public static int gameLoop = 0;

	public static int timeInSeconds;

	public static boolean canStart = false;

	public void onEnable() {
		timeInSeconds = 120;
		canStart = false;
		gameLoop = getServer().getScheduler().scheduleSyncRepeatingTask(this,
				new GameLoop(), 20l, 20l);
	}

	public void onDisable() {
		getServer().getScheduler().cancelTask(gameLoop);
	}

	@EventHandler
	public void onPlayerJoin(PlayerJoinEvent event) {
		canStart = Bukkit.getOnlinePlayers().length >= 4;
	}

	@EventHandler
	public void onPlayerLeave(PlayerQuitEvent event) {
		canStart = Bukkit.getOnlinePlayers().length - 1 >= 4;
	}
}
