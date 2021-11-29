package net.pixelplays.skypvp.scheduler;

import net.kyori.adventure.text.Component;
import net.pixelplays.skypvp.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;

public class TeleportationScheduler {

    private final Player player;

    public int spawnTPStart;
    public int spawnScheduler;

    public TeleportationScheduler(Player player) {
        this.player = player;
    }

    public void startTeleportation() {
        spawnTPStart = 6;
        spawnScheduler = Bukkit.getScheduler().scheduleSyncRepeatingTask(SkyPvP.getInstance(), () -> {
            if (spawnTPStart != 0) {
                spawnTPStart--;
            } else {
                Bukkit.getScheduler().cancelTask(spawnScheduler);
            }
            if (spawnTPStart == 5) {
                player.sendActionBar(Component.text("§7[§c§l♚§7] Teleport in §a§l5 Sekunden §7(Nicht bewegen)"));
            } else if (spawnTPStart == 4) {
                player.sendActionBar(Component.text("§7[§c§l♚§7] Teleport in §a§l4 Sekunden §7(Nicht bewegen)"));
            } else if (spawnTPStart == 3) {
                player.sendActionBar(Component.text("§7[§c§l♚§7] Teleport in §a§l3 Sekunden §7(Nicht bewegen)"));
            } else if (spawnTPStart == 2) {
                player.sendActionBar(Component.text("§7[§c§l♚§7] Teleport in §a§l2 Sekunden §7(Nicht bewegen)"));
            } else if (spawnTPStart == 1) {
                player.sendActionBar(Component.text("§7[§c§l♚§7] Teleport in §a§l1 Sekunde §7(Nicht bewegen)"));
            } else if (spawnTPStart == 0) {
                player.teleport(SkyPvP.getInstance().getLocationAPI().getLocation("Spawn"));
                player.sendActionBar(Component.text("§7[§c§l♚§7]  §a§lTeleportation erfolgreich!"));
            }
        }, 10L, 20L);
    }

    public void cancelTeleport() {
        if (Bukkit.getScheduler().isCurrentlyRunning(spawnScheduler)) {
            Bukkit.getScheduler().cancelTask(spawnScheduler);
            player.sendMessage("Teleportation abgebrochen");
        }
    }

}
