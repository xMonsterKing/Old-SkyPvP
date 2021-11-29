package net.pixelplays.skypvp.commands;

import net.kyori.adventure.text.Component;
import net.pixelplays.skypvp.SkyPvP;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;

public class ChatClearCommand implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {

        Player player = (Player) sender;

        if (command.getName().equalsIgnoreCase("chatclear")) {
            if (sender instanceof ConsoleCommandSender) {
                chatClearPlayers(100, "Console");
            }
            if (!player.hasPermission(SkyPvP.getInstance().getPerms().moderatorPerms)) {
                player.sendMessage(SkyPvP.getInstance().getPerms().noPerms);
                return true;
            }
            chatClearPlayers(100, player.getName());
        }

        return false;
    }

    private void chatClearPlayers(int lines, String name) {
        for (int i = 0; i <= lines; i++) {
            SkyPvP.getInstance().getServer().broadcast(Component.text(""));
        }
        SkyPvP.getInstance().getServer().broadcast(Component.text("§7Der Chat wurde von §c§l" + name + " §7geleert."));
    }
}
