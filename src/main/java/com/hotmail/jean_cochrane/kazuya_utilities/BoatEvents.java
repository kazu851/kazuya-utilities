package com.hotmail.jean_cochrane.kazuya_utilities;


import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Entity;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleEnterEvent;

public class BoatEvents implements Listener {

    @EventHandler
    public void onEntityPlace(VehicleEnterEvent event) {

        Entity entity = event.getEntered();
        
        if (entity.toString() == "CraftZombie" && !ConfigListener.plugin.getConfig().getBoolean("allow-zombie-in-vehicle")) {
            Bukkit.broadcastMessage(ChatColor.GREEN + "<Zombie>: You can't keep me stuck in there!");
            event.setCancelled(true);
        } else if (entity.toString() == "CraftHusk" && !ConfigListener.plugin.getConfig().getBoolean("allow-husk-in-vehicle")) {
            Bukkit.broadcastMessage(ChatColor.YELLOW + "<Husk>: You can't keep me stuck in there!");
            event.setCancelled(true);
        } else if (entity.toString() == "CraftVillagerZombie" && !ConfigListener.plugin.getConfig().getBoolean("allow-villager-zombie-in-vehicle")) {
            Bukkit.broadcastMessage(ChatColor.GREEN + "<Villager Zombie>: You can't keep me stuck in there!");
            event.setCancelled(true);
        }

    }
    
}
