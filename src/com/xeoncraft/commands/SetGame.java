package com.xeoncraft.commands;

import com.xeoncraft.main;
import com.xeoncraft.minigames.KOTAH;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class SetGame implements CommandExecutor {

    String prefix = ChatColor.BLUE + "Game> " + ChatColor.GRAY;
    String error = ChatColor.BLUE + "Error> " + ChatColor.GRAY;
    KOTAH kotah;

    public SetGame(main main)
    {
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
    {
        if(sender instanceof Player);

        if ((cmd.getName().equalsIgnoreCase("setgame")) &&
                ((sender instanceof Player))) {
            Player player = (Player)sender;
            if (args.length == 1) {
                if (args[0].equalsIgnoreCase("kotah")) {
                    player.sendMessage(prefix + "Setting game to " + ChatColor.DARK_GRAY + "King of the Ant Hill" + ChatColor.GRAY + ".");
                    kotah.selectKOTA();
                    return false;
                }
                if (args[0].equalsIgnoreCase("super")) {
                    player.sendMessage(ChatColor.BLUE + "Super Duper!");
                    return false;
                }
                if (args[0].equalsIgnoreCase("unknown")) {
                    player.sendMessage(ChatColor.BLUE + "unknown");
                    return false;
                } else {
                    player.sendMessage(error + "Game not recognized. Please use the following: KOTAH.");
                }
            }
        }
        return false;
    }
}
