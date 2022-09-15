package com.hotmail.jean_cochrane.kazuya_utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Villager;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.VillagerCareerChangeEvent;
import org.bukkit.event.entity.VillagerCareerChangeEvent.ChangeReason;

public class VillagerEvents implements Listener {

    @EventHandler
    public void onrCareerChange(VillagerCareerChangeEvent event) {

        if (event.isCancelled() || event.getEntity() == null || event.getReason() == null) return;
		if (!event.getReason().equals(ChangeReason.EMPLOYED)) return;
		if (ConfigListener.plugin.getConfig().getBoolean("prevent-villagers-career-change")) return;
        
        if (ConfigListener.plugin.getConfig().getBoolean("villager-says-he-studied")){
            Bukkit.broadcastMessage(ChatColor.DARK_AQUA + "<Aldeano>: Lo siento pero ya estudié muchos años como para dejar mi carrera!");
        }
		Villager villager = event.getEntity();
		villager.setVillagerExperience(villager.getVillagerExperience() + 1);

    }
    
}
