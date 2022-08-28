package com.hotmail.jean_cochrane.kazuya_utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.plugin.java.JavaPlugin;

// https://www.youtube.com/watch?v=Hs1kZu1_ruI
// https://github.com/2lstudios-mc/Bukkit-Boilerplate

public class Main extends JavaPlugin {
    public void onEnable(){
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "========================================================");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "========================================================");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Iniciando el plugin de utilidades de kazuya");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "========================================================");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "========================================================");

        getServer().getPluginManager().registerEvents( new ReadChat(), this);
    }
}
