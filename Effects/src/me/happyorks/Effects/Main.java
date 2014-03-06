package me.happyorks.Effects;

import org.bukkit.Effect;
import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.Listener;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public boolean onCommand(CommandSender sender, Command cmd, String name, String[] args){
		if(name.equalsIgnoreCase("effect")){
			playCircularEffect(((Player)sender).getLocation(), Effect.SMOKE, true);
		}
		return false;
	}
	
	public void playCircularEffect(Location location, Effect effect, boolean v){
		for(int i = 0; i <= 8; i += ((!v && (i == 3)) ? 2 : 1)){
			location.getWorld().playEffect(location, effect, i);
		}
	}
	
}
