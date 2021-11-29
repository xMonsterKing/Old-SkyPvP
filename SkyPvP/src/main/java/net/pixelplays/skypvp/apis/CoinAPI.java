package net.pixelplays.skypvp.apis;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.UUID;

public class CoinAPI {

    public static File database;
    public static FileConfiguration cfg;

    public static void readConfig() {
        database = new File("plugins/SkyPvP", "playercoins.yml");
        cfg = YamlConfiguration.loadConfiguration(database);
    }

    public static boolean playerExists(UUID uuid) {
        if (cfg.contains("Coins." + uuid)) {
            return true;
        }
        return false;
    }

    public static void setCoins(UUID uuid, int coins) {
        if (playerExists(uuid)) {
            cfg.set("Coins." + uuid, coins);
            saveFile();
        } else {
            createPlayer(uuid);
            saveFile();
        }
    }

    public static Integer getCoins(UUID uuid) {
        if (playerExists(uuid)) {
            return cfg.getInt("Coins." + uuid);
        } else {
            createPlayer(uuid);
            getCoins(uuid);
        }
        return 0;
    }

    public static void addCoins(UUID uuid, int coins) {
        if (playerExists(uuid)) {
            cfg.set("Coins." + uuid, getCoins(uuid) + coins);
            saveFile();
        } else {
            createPlayer(uuid);
            addCoins(uuid, coins);
        }
    }
    public static void removeCoins(UUID uuid, int coins) {
        if (playerExists(uuid)) {
            cfg.set("Coins." + uuid, getCoins(uuid) - coins);
            saveFile();
        } else {
            createPlayer(uuid);
            removeCoins(uuid, coins);
        }
    }
    public static void createPlayer(UUID uuid) {
        if (!playerExists(uuid)) {
            cfg.set("Coins." + uuid, 1000);
            saveFile();
        }
    }

    public static void saveFile() {
        try {
            cfg.save(database);
        } catch (Exception exc) {
            Bukkit.getConsoleSender().sendMessage("Fehler in playercoins.yml!");
            exc.printStackTrace();
        }
    }

}
