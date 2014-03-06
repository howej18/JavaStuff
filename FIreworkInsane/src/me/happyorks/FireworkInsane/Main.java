package me.happyorks.FireworkInsane;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {

	public void onBlockBreak(final BlockBreakEvent pje){
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
			public void run(){
				
				Firework f = (Firework) pje.getPlayer().getWorld().spawn(pje.getPlayer().getLocation(), Firework.class);
				FireworkMeta fm =f.getFireworkMeta();
				fm.addEffect(FireworkEffect.builder()
						.flicker(false)
                        .trail(true)
                        .with(Type.BALL)
                        .with(Type.BALL_LARGE)
                        .with(Type.STAR)
                        .withColor(Color.ORANGE)
                        .withColor(Color.YELLOW)
                        .withFade(Color.PURPLE)
                        .withFade(Color.RED)
                        .build());
				fm.setPower(1);
				f.setFireworkMeta(fm);	
			}
		}, 0);
	}
	
}
