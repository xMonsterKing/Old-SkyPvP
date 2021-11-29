package net.pixelplays.skypvp.scoreboard;

import eu.imposdev.ucore.scoreboard.FastBoard;
import net.pixelplays.skypvp.apis.CoinAPI;
import net.pixelplays.skypvp.utils.LuckPermsAPIHook;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

import java.util.HashMap;

public class ScoreboardUtil {

    private static final HashMap<Player, FastBoard> boardCache = new HashMap<>();

    public static void sendScoreboard(Player player) {
        FastBoard board = boardCache.get(player);
        if (board == null) {
            board = new FastBoard(player);
            boardCache.put(player, board);
        }

        String group = LuckPermsAPIHook.getGroupOfPlayer(board.getPlayer());
        String color = LuckPermsAPIHook.getPlayerColor(board.getPlayer());

        board.updateTitle("§cSkyPvP");

        board.updateLines(
                "§a",
                "§7Dein Rang",
                "§7➥ " + color + group,
                "§b",
                "§7Spielmünzen",
                "§7➥ §e" + CoinAPI.getCoins(player.getUniqueId()) + " ⛁",
                "§c",
                "§7Clan",
                "§7➥",
                "§d",
                "§7Onlinespieler",
                "§7➥ §a" + Bukkit.getServer().getOnlinePlayers().size() + "§7/" + Bukkit.getServer().getMaxPlayers()
        );
    }



}
