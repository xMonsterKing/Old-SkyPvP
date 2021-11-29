package net.pixelplays.skypvp.apis;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import java.io.File;
import java.util.UUID;

public class KillDeathAPI {

    public static File database;
    public static FileConfiguration cfg;

    public static void readConfig() {
        database = new File("plugins/SkyPvP", "killsdeaths.yml");
        cfg = YamlConfiguration.loadConfiguration(database);
    }

    public static boolean playerExists(UUID uuid) {
        if (cfg.contains(uuid + ".Kill") && cfg.contains(uuid + ".Death")) {
            return true;
        }
        return false;
    }

    public static void createPlayer(UUID uuid) {
        if (!playerExists(uuid)) {
            cfg.set(uuid + ".Kill", 0);
            cfg.set(uuid + ".Death", 0);
            saveFile();
        }
    }

    public static Integer getKills(UUID uuid) {
        if (playerExists(uuid)) {
            return cfg.getInt(uuid + ".Kill");
        } else {
            createPlayer(uuid);
            getKills(uuid);
        }
        return 0;
    }

    public static Integer getDeaths(UUID uuid) {
        if (playerExists(uuid)) {
            return cfg.getInt(uuid + ".Death");
        } else {
            createPlayer(uuid);
            getDeaths(uuid);
        }
        return 0;
    }

    public static void addKills(UUID uuid, int kills) {
        if (playerExists(uuid)) {
            cfg.set(uuid + ".Kill", getKills(uuid) + kills);
            saveFile();
        } else {
            createPlayer(uuid);
            addKills(uuid, kills);
        }
    }

    public static void addDeaths(UUID uuid, int deaths) {
        if (playerExists(uuid)) {
            cfg.set(uuid + ".Death", getDeaths(uuid) + deaths);
            saveFile();
        } else {
            createPlayer(uuid);
            addDeaths(uuid, deaths);
        }
    }

    public static void removeKills(UUID uuid, int kills) {
        if (playerExists(uuid)) {
            cfg.set(uuid + ".Kill", getKills(uuid) - kills);
            saveFile();
        } else {
            createPlayer(uuid);
            removeKills(uuid, kills);
        }
    }

    public static void removeDeaths(UUID uuid, int deaths) {
        if (playerExists(uuid)) {
            cfg.set(uuid + ".Kill", getDeaths(uuid) - deaths);
            saveFile();
        } else {
            createPlayer(uuid);
            removeDeaths(uuid, deaths);
        }
    }

    public static void setKills(UUID uuid, int kills) {
        if (playerExists(uuid)) {
            cfg.set(uuid + ".Kill", kills);
            saveFile();
        } else {
            createPlayer(uuid);
            saveFile();
        }
    }

    public static void setDeaths(UUID uuid, int deaths) {
        if (playerExists(uuid)) {
            cfg.set(uuid + ".Death", deaths);
            saveFile();
        } else {
            createPlayer(uuid);
            saveFile();
        }
    }

    public static void saveFile() {
        try {
            cfg.save(database);
        } catch (Exception exc) {
            Bukkit.getConsoleSender().sendMessage("Fehler in killsdeaths.yml!");
            exc.printStackTrace();
        }
    }

}
