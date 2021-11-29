package net.pixelplays.skypvp.utils;

import net.pixelplays.skypvp.SkyPvP;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.inventory.Inventory;

public class Inventorys {

    public Inventory getBlocksInventory(Player player) {
        Inventory blocksInventory = Bukkit.createInventory(null, 9, SkyPvP.getInstance().getTitles().invTitleBlocks);
        blocksInventory.setItem(0, SkyPvP.getInstance().getItems().blocksPageOne);
        blocksInventory.setItem(2, SkyPvP.getInstance().getItems().blocksPageTwo);
        blocksInventory.setItem(4, SkyPvP.getInstance().getItems().blocksPageThree);
        blocksInventory.setItem(6, SkyPvP.getInstance().getItems().blocksPageFour);
        blocksInventory.setItem(8, SkyPvP.getInstance().getItems().blocksPageFive);
        player.openInventory(blocksInventory);
        player.updateInventory();
        player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_PLING, 1, 1);
        return blocksInventory;
    }

    public Inventory getBlocksInventoryPageOne(Player player) {
        Inventory blockInventoryPageOne = Bukkit.createInventory(null, 9 * 6, SkyPvP.getInstance().getTitles().invTitleBlocksPageOne);
        //blockInventoryPageOne.setItem(1, SkyPvP.getInstance().getItems().);
        return blockInventoryPageOne;
    }

}
