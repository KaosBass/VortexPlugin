package com.xeoncraft.commands;

import com.xeoncraft.main;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class ClearChat implements CommandExecutor {

    public ClearChat(main main)
    {
    }

    String prefix = ChatColor.BLUE + "Chat> " + ChatColor.GRAY;
    String insufperms = ChatColor.BLUE + "Permission> " + ChatColor.RED + "You do not have sufficient permissions to preform this command.";

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {

        Player p = (Player)sender;

        if (cmd.getName().equalsIgnoreCase("clearchat")) {
            if (p.hasPermission("vn.clearchat")) {
                for (Player o : Bukkit.getServer().getOnlinePlayers()) {
                    String msg = "";
                    for (int i = 0; i < 150; i++) {
                        msg = msg + "\n ";
                    }
                    o.sendMessage(msg);
                    o.sendMessage(prefix + "The chat has been cleared by " + ChatColor.LIGHT_PURPLE + p.getName());
                }
                p.sendMessage(prefix + "You have cleared the chat");
            } else {
                p.sendMessage(insufperms);
            }

        }
        return false;
    }
}
