package net.pixelplays.skypvp.commands;

import net.pixelplays.skypvp.SkyPvP;
import net.pixelplays.skypvp.scheduler.TeleportationScheduler;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class SpawnCommand implements CommandExecutor {

    private int spawnTPStart;
    private int spawnScheduler;

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        if (!(sender instanceof Player)) {
            sender.sendMessage(SkyPvP.getInstance().getUtils().onlyPlayerCommand);
        }

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("spawn")) {
            if (args.length == 0) {
                TeleportationScheduler teleportationScheduler = new TeleportationScheduler(player);
                teleportationScheduler.startTeleportation();
            }
        }

        return true;
    }

}
