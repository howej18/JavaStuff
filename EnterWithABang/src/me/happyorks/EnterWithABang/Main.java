package me.happyorks.EnterWithABang;

import java.util.logging.Logger;

import org.bukkit.Bukkit;
import org.bukkit.Color;
import org.bukkit.FireworkEffect;
import org.bukkit.FireworkEffect.Type;
import org.bukkit.entity.Firework;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.inventory.meta.FireworkMeta;
import org.bukkit.plugin.PluginDescriptionFile;
import org.bukkit.plugin.java.JavaPlugin;

public class Main extends JavaPlugin implements Listener {
	public final Logger logger = Logger.getLogger("Minecraft");
	public static Main plugin;
	
	public void onEnable(){
		Bukkit.getServer().getPluginManager().registerEvents(this, this);
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " Version " + pdfFile.getVersion() + " has been enabled!");
	}
	
	public void onDisable(){
		PluginDescriptionFile pdfFile = this.getDescription();
		this.logger.info(pdfFile.getName() + " has been disabled!");
	}
	
	@EventHandler
	public void onPlayerJoin(final PlayerJoinEvent pje){
		
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
			}, 20);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
			public void run(){
				
				Firework f2 = (Firework) pje.getPlayer().getWorld().spawn(pje.getPlayer().getLocation(), Firework.class);
				FireworkMeta fm2 =f2.getFireworkMeta();
				fm2.addEffect(FireworkEffect.builder()
						.flicker(false)
                        .trail(true)
                        .with(Type.BALL)
                        .with(Type.BALL_LARGE)
                        .with(Type.STAR)
                        .withColor(Color.BLUE)
                        .withColor(Color.GREEN)
                        .withFade(Color.PURPLE)
                        .withFade(Color.RED)
                        .build());
				fm2.setPower(1);
				f2.setFireworkMeta(fm2);
				
			}
		}, 30);
		
		Bukkit.getServer().getScheduler().scheduleSyncDelayedTask(this, new Runnable(){
			public void run(){

				Firework f3 = (Firework) pje.getPlayer().getWorld().spawn(pje.getPlayer().getLocation(), Firework.class);
				FireworkMeta fm3 =f3.getFireworkMeta();
				fm3.addEffect(FireworkEffect.builder()
						.flicker(false)
                        .trail(true)
                        .with(Type.BALL)
                        .with(Type.BALL_LARGE)
                        .with(Type.STAR)
                        .withColor(Color.FUCHSIA)
                        .withColor(Color.LIME)
                        .withFade(Color.PURPLE)
                        .withFade(Color.RED)
                        .build());
				fm3.setPower(1);
				f3.setFireworkMeta(fm3);
				
				
			}
		}, 40);
		
		
		}
		
	}


