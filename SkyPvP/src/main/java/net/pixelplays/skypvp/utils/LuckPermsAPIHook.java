package net.pixelplays.skypvp.utils;

import net.luckperms.api.model.group.Group;
import net.luckperms.api.model.user.User;
import net.luckperms.api.platform.PlayerAdapter;
import net.pixelplays.skypvp.SkyPvP;
import org.bukkit.entity.Player;

import java.util.Collection;
import java.util.stream.Collectors;

public class LuckPermsAPIHook {

    public static boolean isPlayerInGroup(final Player player, final String group) {
        return player.hasPermission("group." + group);
    }

    public static String getGroupOfPlayer(Player player) {
        PlayerAdapter<Player> playerAdapter = SkyPvP.getInstance().getLuckPerms().getPlayerAdapter(Player.class);
        User user = playerAdapter.getUser(player);
        Collection<Group> groups = user.getInheritedGroups(playerAdapter.getQueryOptions(player));
        String finalGroup = groups.stream().map(Group::getName).collect(Collectors.joining(";"));
        String[] groupData = finalGroup.split(";");
        return groupData[0].substring(0, 1).toUpperCase() + groupData[0].substring(1);
    }

    public static String getPlayerColor(Player player) {
        String color;
        {
            color = "§7";
        }
        if (player.hasPermission("rang.premium")) {
            color = "§6";
        }
        if (player.hasPermission("rang.superior")) {
            color = "§c";
        }
        if (player.hasPermission("rang.yt")) {
            color = "§5";
        }
        if (player.hasPermission("rang.builder")) {
            color = "§2";
        }
        if (player.hasPermission("rang.sup")) {
            color = "§9";
        }
        if (player.hasPermission("rang.mod")) {
            color = "§3";
        }
        if (player.hasPermission("rang.dev")) {
            color = "§b";
        }
        if (player.hasPermission("rang.content")) {
            color = "§e";
        }
        if (player.hasPermission("rang.admin")) {
            color = "§c";
        }
        if (player.hasPermission("rang.leitung")) {
            color = "§4";
        }
        return color;
    }

}
