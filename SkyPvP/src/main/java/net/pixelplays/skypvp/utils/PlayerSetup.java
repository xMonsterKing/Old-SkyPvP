package net.pixelplays.skypvp.utils;

import net.pixelplays.skypvp.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.Location;
import org.bukkit.entity.Player;

public class PlayerSetup {

    private final Player player;

    /**
     * Constructor to create a player. Used for inventory setup, animations, etc.
     *
     * @param player Defines the player that should be set up.
     *
     */
    public PlayerSetup(Player player) {
        this.player = player;
    }

    /**
     * Setup all parts at once.
     */
    public void setupPlayer() {
        setPlayerAttributes();
    }

    private void setPlayerAttributes() {
        player.setGameMode(GameMode.SURVIVAL);
        player.setHealthScale(20D);
        player.setHealth(20D);
        player.setFoodLevel(40);
        player.setFlying(false);
        if (player.hasPermission(SkyPvP.getInstance().getPerms().godPerms)) {
            player.setAllowFlight(true);
        }
        Location spawn = SkyPvP.getInstance().getLocationAPI().getLocation("Spawn");
        if (spawn != null) {
            Bukkit.getScheduler().scheduleSyncDelayedTask(SkyPvP.getInstance(), () -> {
                player.teleport(spawn);
            }, 7L);
        }
    }

    /**
     * Get the player from the constructor.
     * @return Bukkit Player Object.
     */
    public Player getPlayer() {
        return player;
    }

}
