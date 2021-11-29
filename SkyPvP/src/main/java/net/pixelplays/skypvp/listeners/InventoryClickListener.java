package net.pixelplays.skypvp.listeners;

import net.kyori.adventure.text.Component;
import net.pixelplays.skypvp.SkyPvP;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;

public class InventoryClickListener implements Listener {

    @EventHandler
    public void onInventoryClick(InventoryClickEvent event) {
        Player player = (Player) event.getWhoClicked();

        if (event.getView().getTitle().equalsIgnoreCase(SkyPvP.getInstance().getTitles().invTitleBlocks)) {
            event.setCancelled(true);
            if (event.getCurrentItem() != null
                    && event.getCurrentItem().getItemMeta().displayName().contains(Component.text("§aBlöcke §7(Seite 1)"))) {
                //run code
            }
        }
    }

}
