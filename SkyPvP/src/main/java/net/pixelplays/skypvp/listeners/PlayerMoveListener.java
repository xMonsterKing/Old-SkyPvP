package net.pixelplays.skypvp.listeners;

import net.pixelplays.skypvp.scheduler.TeleportationScheduler;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerMoveEvent;

public class PlayerMoveListener implements Listener {

    @EventHandler
    public void onPlayerMove(PlayerMoveEvent event) {
        Player player = event.getPlayer();
        TeleportationScheduler teleportationScheduler = new TeleportationScheduler(player);
        teleportationScheduler.cancelTeleport();
    }

}
