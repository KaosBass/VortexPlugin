package com.xeoncraft;

import com.xeoncraft.commands.*;
import com.xeoncraft.events.PJoinEvent;
import com.xeoncraft.events.PQuitEvent;
import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Damageable;
import org.bukkit.entity.Player;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class main extends JavaPlugin {

    public static File playerstats = new File("plugins/OverPoweredPlugin", "playerstats.yml");
    public static File homepoints = new File("plugins/OverPoweredPlugin", "homepoints.yml");

    public static FileConfiguration stats = YamlConfiguration.loadConfiguration(playerstats);
    public static FileConfiguration homes = YamlConfiguration.loadConfiguration(homepoints);

    public static ArrayList<String> onlineplayers = new ArrayList();

    private PJoinEvent PJoinEvent = new PJoinEvent(this);
    private PQuitEvent PQuitEvent = new PQuitEvent(this);

    public void onEnable() {

        System.out.println("TechCore has been activated! -created by Whiztech");

        registerFiles();
        registerCommands();
        registerEvents();

        for (Player o : Bukkit.getOnlinePlayers()) {
            onlineplayers.add(o.getName());
        }

    }

    public void registerCommands() {
        getCommand("helpbook").setExecutor(new Helpbook(this));
        getCommand("fly").setExecutor(new Fly(this));
        getCommand("playerinfo").setExecutor(new Playerinfo(this));
        getCommand("sethome").setExecutor(new Homes(this));
        getCommand("home").setExecutor(new Homes(this));
        getCommand("faster").setExecutor(new Speed(this));
        getCommand("tphere").setExecutor(new TPhere(this));
        getCommand("clearchat").setExecutor(new ClearChat(this));
        getCommand("setgame").setExecutor(new SetGame(this));
        getCommand("startgame").setExecutor(new SetGame(this));
    }

    public void registerEvents() {
        PluginManager pm = Bukkit.getPluginManager();

        pm.registerEvents(this.PJoinEvent, this);
        pm.registerEvents(this.PQuitEvent, this);
    }

    public void registerFiles() {
        if (!playerstats.exists()) try { playerstats.createNewFile(); } catch (IOException e) { e.printStackTrace(); }
        if (!homepoints.exists()) try { homepoints.createNewFile(); } catch (IOException e) { e.printStackTrace(); }
    }

    public static void setPlayerStats(Player p) throws IOException {
        Damageable d = p;
        stats.set("Player." + p.getName() + ".Playername", p.getName());
        stats.set("Player." + p.getName() + ".Foodlevel", Integer.valueOf(p.getFoodLevel()));
        stats.set("Player." + p.getName() + ".Level", Integer.valueOf(p.getLevel()));
        stats.set("Player." + p.getName() + ".Firstplayed", Long.valueOf(p.getFirstPlayed()));
        stats.set("Player." + p.getName() + ".World", p.getWorld().getName());
        stats.set("Player." + p.getName() + ".Location.X", Integer.valueOf(p.getLocation().getBlockX()));
        stats.set("Player." + p.getName() + ".Location.Y", Integer.valueOf(p.getLocation().getBlockY()));
        stats.set("Player." + p.getName() + ".Location.Z", Integer.valueOf(p.getLocation().getBlockZ()));
        stats.save(playerstats);
    }


}





