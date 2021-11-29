package net.pixelplays.skypvp.commands;

import net.pixelplays.skypvp.SkyPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class BlocksCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(SkyPvP.getInstance().getUtils().onlyPlayerCommand);
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("blocks")) {
            if (!player.hasPermission(SkyPvP.getInstance().getPerms().kingPerms)) {
                player.sendMessage(SkyPvP.getInstance().getPerms().noPerms);
            } else {
                if (args.length == 0) {
                    SkyPvP.getInstance().getInventorys().getBlocksInventory(player);
                } else if (args.length == 1) {
                    if (args[0].equalsIgnoreCase("1")) {
                        //run command
                        player.sendMessage("kommt noch!");
                    }
                } else {
                    player.sendMessage(SkyPvP.getInstance().getUtils().Prefix + "§7Nutze: §e/blocks oder /blocks <Seite 1-5>");
                }
            }
        }

        return false;
    }
}
