package net.pixelplays.skypvp.commands;

import net.pixelplays.skypvp.SkyPvP;
import net.pixelplays.skypvp.apis.CoinAPI;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class CoinsCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(SkyPvP.getInstance().getUtils().onlyPlayerCommand);
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("coins")) {
            if (args.length == 0) {
                player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§6Deine Spielmünzen §7» §e" + CoinAPI.getCoins(player.getUniqueId()) + " ⛁");
            }
            if (args.length == 3) {
                if (args[0].equalsIgnoreCase("add")) {
                    if (!player.hasPermission(SkyPvP.getInstance().getPerms().adminPerms)) {
                        player.sendMessage(SkyPvP.getInstance().getPerms().noPerms);
                    } else {
                        int i;
                        try {
                            i = Integer.parseInt(args[2]);
                        } catch (Exception e) {
                            player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§6" + args[2] + " §7ist keine Zahl!");
                            return true;
                        }
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null) {
                            if (!(i < 1)) {
                                CoinAPI.addCoins(target.getUniqueId(), i);
                                player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Du hast §a" + target.getName() + " §6" + i + " Spielmünze/n §7gegeben");
                                target.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Dir wurden §6" + i + " Spielmünze/n §7deinem Konto hinzugefügt");
                            } else {
                                player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§cDu kannst dem Spieler nicht weniger als 1 Spielmünzen geben!");
                            }
                        } else {
                            player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§cNutze: /coins add <Spielername> <Anzahl>");
                        }
                    }
                } else if (args[0].equalsIgnoreCase("remove")) {
                    if (!player.hasPermission(SkyPvP.getInstance().getPerms().adminPerms)) {
                        player.sendMessage(SkyPvP.getInstance().getPerms().noPerms);
                    } else {
                        int i;
                        try {
                            i = Integer.parseInt(args[2]);
                        } catch (Exception e) {
                            player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§6" + args[2] + " §7ist keine Zahl!");
                            return true;
                        }
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null) {
                            if (!(i < 1)) {
                                CoinAPI.removeCoins(target.getUniqueId(), i);
                                player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Du hast §a" + target.getName() + " §6" + i + " Spielmünze/n §7gegeben");
                                target.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Dir wurden §6" + i + " Spielmünze/n §7deinem Konto hinzugefügt");
                            } else {
                                player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§cDu kannst dem Spieler nicht weniger als 1 Spielmünzen geben!");
                            }
                        } else {
                            player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§cNutze: /coins add <Spielername> <Anzahl>");
                        }
                    }
                } else if (args[0].equalsIgnoreCase("set")) {
                    if (!player.hasPermission(SkyPvP.getInstance().getPerms().adminPerms)) {
                        player.sendMessage(SkyPvP.getInstance().getPerms().noPerms);
                    } else {
                        int i;
                        try {
                            i = Integer.parseInt(args[2]);
                        } catch (Exception e) {
                            player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§6" + args[2] + " §7ist keine Zahl!");
                            return true;
                        }
                        Player target = Bukkit.getPlayer(args[1]);
                        if (target != null) {
                            if (!(i < 1)) {
                                CoinAPI.addCoins(target.getUniqueId(), i);
                                player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Du hast §a" + target.getName() + "'s §6Spielmünzen §7auf §6" + i + " §7gesetzt");
                                target.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Deine §6Spielmünzen §7wurden auf §6" + i + " §7gesetzt");
                            } else {
                                player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§cDu kannst dem Spieler nicht weniger als 1 Spielmünzen setzen!");
                            }
                        } else {
                            player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§cNutze: /coins set <Spielername> <Anzahl>");
                        }
                    }
                }
            }
        }

        return true;
    }
}
