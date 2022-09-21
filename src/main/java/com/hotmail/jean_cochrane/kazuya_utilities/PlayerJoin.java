package com.hotmail.jean_cochrane.kazuya_utilities;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class PlayerJoin implements Listener  {

    @EventHandler
    public void onPlayerJoin(PlayerJoinEvent event) {
        Player player = event.getPlayer();

        

        if (ConfigListener.plugin.getConfig().getBoolean("wellcome-message-active")) {
            player.sendMessage(ChatColor.GRAY + ConfigListener.plugin.getConfig().getString("wellcome-message"));
        }

        if (ConfigListener.plugin.getConfig().getBoolean("plugin-info-message-active")) {
            player.sendMessage(ChatColor.GRAY + "You are using Kazuya-Utilities 1.0.2");
        }

        if (player.isOp() && ConfigListener.plugin.getConfig().getBoolean("hide-op-join-quit-message")) {
            player.sendMessage(ChatColor.GRAY + "Wellcome admin " + player.getName() + ", join game message hidden.");
            event.setJoinMessage(null);
        }
    
    }

    @EventHandler
    public void onPlayerQuit(PlayerQuitEvent event) {
        Player player = event.getPlayer();

        if (player.isOp()) {
        event.setQuitMessage(null);
        }
    }
    
}
