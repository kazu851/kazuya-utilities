package com.hotmail.jean_cochrane.kazuya_utilities;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.hotmail.jean_cochrane.MainCommand;


// https://www.youtube.com/watch?v=Hs1kZu1_ruI
// https://github.com/2lstudios-mc/Bukkit-Boilerplate

public class Main extends JavaPlugin {
    public void onEnable(){

        loadConfig();

        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "========================================================");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "========================================================");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "Iniciando el plugin de utilidades de kazuya");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "========================================================");
        Bukkit.getServer().getConsoleSender().sendMessage(ChatColor.GREEN + "========================================================");
        
        PluginManager pm = getServer().getPluginManager();
        pm.registerEvents( new ConfigListener(this), this);
        pm.registerEvents( new PlayerJoin(), this);
        pm.registerEvents( new ReadChat(), this);
        
        getCommand("kazuya-utilities").setExecutor(new MainCommand());
    }



    public void loadConfig(){

        FileConfiguration config = this.getConfig();

        config.addDefault("wellcome-message-active", true);
        config.addDefault("wellcome-message", "Bienvenido al complemento de Kazuya");
        config.addDefault("plugin-info-message-active", true);
        config.options().copyDefaults(true);
        saveConfig();

    }

}
