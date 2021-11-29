package net.pixelplays.skypvp.utils;

import net.pixelplays.skypvp.SkyPvP;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.io.IOException;

public class ConfigFile {

    private File getFile() {
        return new File("plugins/SkyPvP", "config.yml");
    }

    private FileConfiguration getFileConfiguration() {
        return YamlConfiguration.loadConfiguration(getFile());
    }

    public void setStandard() {
        FileConfiguration cfg = getFileConfiguration();
        cfg.options().copyDefaults(true);

        cfg.options().header("SkyPvP System by xMonsterKing | Copyright (c) 2021. All rights reserved.");
        cfg.addDefault("Prefix", "§cSkyPvP §7|§r ");
        cfg.addDefault("Messages.Welcome", "§7Willkommen §c%player% §7auf dem SkyPvP Server");

        /*cfg.addDefault("InventoryTitles.Blocks.Main", "§aBlöcke");
        cfg.addDefault("InventoryTitles.Blocks.PageOne", "§aBlöcke §7(Seite 1)");
        cfg.addDefault("InventoryTitles.Blocks.PageTwo", "§aBlöcke §7(Seite 2)");
        cfg.addDefault("InventoryTitles.Blocks.PageThree", "§aBlöcke §7(Seite 3)");
        cfg.addDefault("InventoryTitles.Blocks.PageFour", "§aBlöcke §7(Seite 4)");
        cfg.addDefault("InventoryTitles.Blocks.PageFive", "§aBlöcke §7(Seite 5)");*/

        cfg.addDefault("Permissions.NoPerms", "§cDazu hast du keine Rechte");
        cfg.addDefault("Permissions.Admin", "rang.admin");
        cfg.addDefault("Permissions.SrModerator", "rang.srmoderator");
        cfg.addDefault("Permissions.Moderator", "rang.moderator");
        cfg.addDefault("Permissions.Developer", "rang.developer");
        cfg.addDefault("Permissions.Supporter", "rang.supporter");
        cfg.addDefault("Permissions.Builder", "rang.builder");
        cfg.addDefault("Permissions.Apprentice", "rang.apprentice");
        cfg.addDefault("Permissions.Superior", "rang.superior");
        cfg.addDefault("Permissions.God", "rang.god");
        cfg.addDefault("Permissions.King", "rang.king");
        cfg.addDefault("Permissions.Knight", "rang.knight");
        cfg.addDefault("Permissions.Player", "rang.player");

        cfg.addDefault("Utils.OnlyPlayerCommand", "Dieser Command kann nur von einem Spieler ausgeführt werden");

        try {
            cfg.save(getFile());
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void readData() {
        FileConfiguration cfg = getFileConfiguration();
        SkyPvP.getInstance().getUtils().Prefix = cfg.getString("Prefix");
        SkyPvP.getInstance().getUtils().Welcome = cfg.getString("Messages.Welcome");

        /*SkyPvP.getInstance().getTitles().invTitleBlocks = cfg.getString("InventoryTitle.Blocks.Main");
        SkyPvP.getInstance().getTitles().invTitleBlocksPageOne = cfg.getString("InventoryTitle.Blocks.PageOne");
        SkyPvP.getInstance().getTitles().invTitleBlocksPageTwo = cfg.getString("InventoryTitle.Blocks.PageTwo");
        SkyPvP.getInstance().getTitles().invTitleBlocksPageThree = cfg.getString("InventoryTitle.Blocks.PageThree");
        SkyPvP.getInstance().getTitles().invTitleBlocksPageFour = cfg.getString("InventoryTitle.Blocks.PageFour");
        SkyPvP.getInstance().getTitles().invTitleBlocksPageFive = cfg.getString("InventoryTitle.Blocks.PageFive");*/

        SkyPvP.getInstance().getPerms().noPerms = cfg.getString("Permissions.NoPerms");
        SkyPvP.getInstance().getPerms().adminPerms = cfg.getString("Permissions.Admin");
        SkyPvP.getInstance().getPerms().srModeratorPerms = cfg.getString("Permissions.SrModerator");
        SkyPvP.getInstance().getPerms().moderatorPerms = cfg.getString("Permissions.Moderator");
        SkyPvP.getInstance().getPerms().developerPerms = cfg.getString("Permissions.Developer");
        SkyPvP.getInstance().getPerms().supporterPerms = cfg.getString("Permissions.Supporter");
        SkyPvP.getInstance().getPerms().builderPerms = cfg.getString("Permissions.Builder");
        SkyPvP.getInstance().getPerms().apprenticePerms = cfg.getString("Permissions.Apprentice");
        SkyPvP.getInstance().getPerms().superiorPerms = cfg.getString("Permissions.Superior");
        SkyPvP.getInstance().getPerms().godPerms = cfg.getString("Permissions.God");
        SkyPvP.getInstance().getPerms().kingPerms = cfg.getString("Permissions.King");
        SkyPvP.getInstance().getPerms().knightPerms = cfg.getString("Permissions.Knight");
        SkyPvP.getInstance().getPerms().playerPerms = cfg.getString("Permissions.Player");

        SkyPvP.getInstance().getUtils().onlyPlayerCommand = cfg.getString("Utils.OnlyPlayerCommand");
    }

}
