package com.hotmail.jean_cochrane.kazuya_utilities;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

public class ReadChat implements Listener {

    @EventHandler
    public void onPlayerChat(AsyncPlayerChatEvent event){
        Player player = event.getPlayer();

        String[] creeperMessages = new String []{
            "Iremos por ti una y otra vez " + player.getName(),
            "Y vendremos más a por tu casa!",
            "Otra vez nos mencionas " + player.getName() + "?!",
            "Estamos cerca!!",
            "Estamos muy cerca",
            "Pronto oirás BOOM!",
            "Detras de tí " + player.getName() + "!!"
        };

        String[] lagMessages = new String []{
            "Server: Lag?? De seguro es culpa de edogiro!",
            "Server: Lag?? Que asco! De seguro eres de LATAM!!",
            "Server: No vale jugar en calculadoras!",
            "Server: Lag?? Deja de robarle el Wifi al vecino " + player.getName() + "!!",
            "Server: Lag?? Cambiate a Claro!"
        };

        String[] illegalMessages = new String []{
            "Server: Vegetta777 Apoya el comentario!",
            "<SrAuronPlay>: Eso es ilegalisimo!!... baneao 3 meses!",
            "<SrAuronPlay>: Chetadisimo!! ilegalisimo!!... damelo!",
            "<SrAuronPlay>: ilegalisimo!! " + player.getName() + " dime todo lo que sepas o tambien te vas baneao!",
            "<SrAuronPlay>: ilegal!!!",
        };

        int min = 0;
        int rand; 

        if (event.getMessage().toLowerCase().contains("creeper")) {
            rand  = (int)(Math.random() * creeperMessages.length - 1) + min;
            CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS).execute(() -> {
                Bukkit.broadcastMessage(ChatColor.GREEN + "<Creeper King>: " + creeperMessages[rand]);
              });
        } else if (event.getMessage().toLowerCase().contains("lag")) {
            rand  = (int)(Math.random() * lagMessages.length - 1) + min;
            CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS).execute(() -> {
                Bukkit.broadcastMessage(ChatColor.YELLOW + lagMessages[rand]);
              });
        } else if (event.getMessage().toLowerCase().contains("ilegalisimo")) {
            rand  = (int)(Math.random() * illegalMessages.length - 1) + min;
            CompletableFuture.delayedExecutor(1, TimeUnit.SECONDS).execute(() -> {
                Bukkit.broadcastMessage(ChatColor.BLUE + illegalMessages[rand]);
              });
        }
    }
    
}
