package com.hotmail.jean_cochrane.kazuya_utilities;

import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;

import net.md_5.bungee.api.ChatColor;


public class ClockEvents implements Listener {

    @EventHandler
    public void onPlayerUse(PlayerInteractEvent event){
    Player player = event.getPlayer();
    String overWorldName = Bukkit.getWorlds().get(0).getName();
    long time = Bukkit.getServer().getWorld(overWorldName).getTime();
    int hours = (int) ((Math.floor(time / 1000.0) + 8) % 24) - 2; // '8' is the offset
    int minutes = (int) Math.floor((time % 1000) / 1000.0 * 60);
    
    if (ConfigListener.plugin.getConfig().getBoolean("clocks-show-time")) {
        if (event.getAction().toString().toUpperCase() == "RIGHT_CLICK_AIR") {
            if (player.getInventory().getItemInMainHand().getType().name().toString().equalsIgnoreCase("WATCH")) {
                player.sendMessage(ChatColor.GOLD + "Overworld Time: " + String.format("%02d:%02d", hours, minutes) + ChatColor.GREEN + " <-- Capricho de PeChErMaN755 y edogiro");
            }
        }
    }
    
    
    
}
    
}
