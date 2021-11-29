package net.pixelplays.skypvp.commands;

import net.kyori.adventure.text.Component;
import net.pixelplays.skypvp.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BroadCastCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(SkyPvP.getInstance().getUtils().onlyPlayerCommand);
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("broadcast")) {
            if (!player.hasPermission(SkyPvP.getInstance().getPerms().srModeratorPerms)) {
                player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + SkyPvP.getInstance().getPerms().noPerms);
            } else {
                if (args.length >= 1) {
                    String message = "";
                    for (int i = 0; i < args.length; i++) {
                        message = message + args[i] + " ";
                    }
                    Bukkit.broadcast(Component.text(""));
                    Bukkit.broadcast(Component.text(SkyPvP.getInstance().getUtils().Prefix + message.replaceAll("&", "§")));
                    Bukkit.broadcast(Component.text(""));

                    Bukkit.getOnlinePlayers().forEach(players -> players.playSound(players.getLocation(), Sound.ENTITY_PLAYER_LEVELUP, 1, 2));

                } else {
                    player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Nutze: §e/broadcast <Message>");
                }
            }
        }

        return false;
    }
}
