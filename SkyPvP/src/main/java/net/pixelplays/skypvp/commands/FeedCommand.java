package net.pixelplays.skypvp.commands;

import net.pixelplays.skypvp.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class FeedCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(SkyPvP.getInstance().getUtils().onlyPlayerCommand);
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("feed")) {
            if (!player.hasPermission(SkyPvP.getInstance().getPerms().knightPerms)) {
                player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + SkyPvP.getInstance().getPerms().noPerms);
            } else {
                if (args.length == 0) {
                    player.setFoodLevel(20);
                    player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Dein Hunger wurde gestillt.");
                } else if (args.length == 1) {
                    if (!player.hasPermission(SkyPvP.getInstance().getPerms().moderatorPerms)) {
                        player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + SkyPvP.getInstance().getPerms().noPerms);
                    } else {
                        Player target = Bukkit.getServer().getPlayer(args[0]);
                        if (target == null) {
                            player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§cDieser Spieler ist nicht online.");
                        } else {
                            target.setFoodLevel(20);
                            target.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Dein Hunger wurde gestillt.");
                            player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Du hast §e" + target.getName() + "'s §7Hunger gestillt.");
                        }
                    }
                }
            }
        }
        return false;
    }
}
