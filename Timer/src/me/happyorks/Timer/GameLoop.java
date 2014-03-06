package me.happyorks.Timer;

import org.bukkit.Bukkit;

public class GameLoop implements Runnable {

	public void run() {
		if(Main.timeInSeconds >= 60 && Main.timeInSeconds % 60 == 0){
			broadcastTimeUntilStart(true);
		}
		if(Main.timeInSeconds <= 30 && Main.timeInSeconds % 15 == 0 && Main.timeInSeconds > 0){
			broadcastTimeUntilStart(true);
		}
		if(Main.timeInSeconds <= 10 && Main.timeInSeconds > 0){
			broadcastTimeUntilStart(false);
			note();
		}
		if(Main.timeInSeconds == 0){
			if(Main.canStart)
				Bukkit.broadcastMessage(" GAME STARTED ");
			else{
				Bukkit.broadcastMessage("Not enought players. Resetting timer!")
				resetNote();
				Main.timeInSeconds = 121;
			}
		}
		if(Main.timeInSeconds > 0){
			Main.timeInSeconds --;
		}
	}

	private void resetNote() {
		// TODO Auto-generated method stub
		
	}

	private void note() {
		// TODO Auto-generated method stub
		
	}

	private void broadcastTimeUntilStart(boolean b) {
		if(Main.timeInSeconds % 60 == 0 && Main.timeInSeconds >= 60){
			Bukkit.broadcastMessage(Main.timeInSeconds + "Minutes until start!");
		}else if(Main.timeInSeconds % 15 == 0 && Main.timeInSeconds < 60){
			Bukkit.broadcastMessage(Main.timeInSeconds + "Seconds until game starts!");
		}
	}
}
