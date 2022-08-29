package com.hotmail.jean_cochrane;


import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.event.Listener;
import org.bukkit.plugin.Plugin;
import org.bukkit.ChatColor;


public class MainCommand implements Listener, CommandExecutor {

    final Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("kazuya-utilities");
    final FileConfiguration config = plugin.getConfig();



    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {

        if (command.getName().equalsIgnoreCase("kazuya-utilities")) {

            if(args.length == 1 && args[0].equalsIgnoreCase("reload")) {

                if (sender.hasPermission("kazu-util.reload")) {

                    plugin.reloadConfig();
                    sender.sendMessage(ChatColor.GREEN + "Configuration reloaded");

                    return true;

                } else  {

                    sender.sendMessage(ChatColor.RED + "You dont have permissions to execute this command");

                    return true;

                }

            } else if (args.length == 0) {
                sender.sendMessage(ChatColor.RED + "you need at least one argument");
            } else if (args.length > 1) {
                sender.sendMessage(ChatColor.RED + "too many arguments");
            } else {
                sender.sendMessage(ChatColor.RED + "incorrect arguments");
            }

        }

        return true;

    }

}