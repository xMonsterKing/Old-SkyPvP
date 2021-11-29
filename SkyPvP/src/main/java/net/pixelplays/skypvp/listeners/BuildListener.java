package net.pixelplays.skypvp.listeners;

import net.pixelplays.skypvp.SkyPvP;
import org.bukkit.GameMode;
import org.bukkit.World;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockBreakEvent;
import org.bukkit.event.block.BlockPlaceEvent;

public class BuildListener implements Listener {

    @EventHandler
    public void onBlockPlace(BlockPlaceEvent event) {
        final Player player = event.getPlayer();
        World spawn = SkyPvP.getInstance().getLocationAPI().getLocation("Spawn").getWorld();
        if (!(player.getGameMode() == GameMode.CREATIVE)) {
            if (player.getLocation().getWorld().equals(spawn)) {
                event.setCancelled(true);
            } else {
                event.setCancelled(false);
            }
        } else {
            event.setCancelled(false);
        }
    }

    @EventHandler
    public void onBlockBreak(BlockBreakEvent event) {
        final Player player = event.getPlayer();
        World spawn = SkyPvP.getInstance().getLocationAPI().getLocation("Spawn").getWorld();
        if (!(player.getGameMode() == GameMode.CREATIVE)) {
            if (player.getLocation().getWorld().equals(spawn)) {
                event.setCancelled(true);
            } else {
                event.setCancelled(false);
            }
        } else {
            event.setCancelled(false);
        }
    }

}
