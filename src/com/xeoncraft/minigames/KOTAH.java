package com.xeoncraft.minigames;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.WorldCreator;

import java.util.Timer;

public class KOTAH {

    Timer timer;

    String prefix = ChatColor.BLUE + "Game> " + ChatColor.GRAY;
    GameState state;

    public void selectKOTA() {
        broadcastCurrentGame();

    }

    public void startKOTAH() {

        state = GameState.INGAME;

        loadKOTAH();
    }

    public void broadcastCurrentGame() {
        Bukkit.broadcastMessage(prefix + "Game has been set to " + ChatColor.DARK_GRAY + "King of the Ant Hill" + ChatColor.GRAY + ".");
    }

    public void loadKOTAH() {
        Bukkit.unloadWorld("world", false);
        Bukkit.createWorld(new WorldCreator("KOTA"));
    }

}
