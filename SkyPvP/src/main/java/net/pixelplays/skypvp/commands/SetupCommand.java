package net.pixelplays.skypvp.commands;

import net.pixelplays.skypvp.SkyPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SetupCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(SkyPvP.getInstance().getUtils().onlyPlayerCommand);
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("setup")) {
            if (!player.hasPermission(SkyPvP.getInstance().getPerms().adminPerms)) {
                player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + SkyPvP.getInstance().getPerms().noPerms);
            } else {
                if (args.length < 1) {
                    player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Nutze: §e/setup setSpawn, setNPC <Shop>");
                }
                if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("setSpawn")) {
                        player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Du hast den Spawn erfolgreich gesetzt!");
                        SkyPvP.getInstance().getLocationAPI().saveLocation("Spawn", player.getLocation());
                    }
                }
                if (args.length == 2) {
                    if (args[0].equalsIgnoreCase("setNPC")) {
                        if (args[1].equalsIgnoreCase("shop")) {
                            player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Du hast den Shop NPC erfolgreich gesetzt!");
                            SkyPvP.getInstance().getLocationAPI().saveLocation("NPC.Shop", player.getLocation());
                        } else if (args[1].equalsIgnoreCase("ranginfo")) {
                            player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Du hast den Ranginfo NPC erfolgreich gesetzt!");
                            SkyPvP.getInstance().getLocationAPI().saveLocation("NPC.Ranginfo", player.getLocation());
                        } else if (args[1].equalsIgnoreCase("kits")) {
                            player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Du hast den Kits NPC erfolgreich gesetzt!");
                            SkyPvP.getInstance().getLocationAPI().saveLocation("NPC.Kits", player.getLocation());
                        } else if (args[1].equalsIgnoreCase("job")) {
                            player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Du hast den Job NPC erfolgreich gesetzt!");
                            SkyPvP.getInstance().getLocationAPI().saveLocation("NPC.Job", player.getLocation());
                        }
                    }
                }
            }
        }

        return true;
    }
}
