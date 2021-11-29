package net.pixelplays.skypvp;

import com.github.juliarn.npc.NPCPool;
import net.luckperms.api.LuckPerms;
import net.luckperms.api.LuckPermsProvider;
import net.pixelplays.skypvp.apis.CoinAPI;
import net.pixelplays.skypvp.apis.KillDeathAPI;
import net.pixelplays.skypvp.apis.LocationAPI;
import net.pixelplays.skypvp.commands.*;
import net.pixelplays.skypvp.listeners.*;
import net.pixelplays.skypvp.utils.*;
import net.pixelplays.skypvp.utils.npc.NPCUtil;
import org.bukkit.Bukkit;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

public final class SkyPvP extends JavaPlugin {

    private static SkyPvP instance;

    private NPCPool npcPool;
    private NPCUtil npcUtil;

    private LocationAPI locationAPI;

    private LuckPerms luckPerms;

    private Utils utils;
    private Titles titles;
    private Inventorys inventorys;
    private Items items;
    private Perms perms;

    @Override
    public void onLoad() {
        instance = this;

        locationAPI = new LocationAPI();
    }

    @Override
    public void onEnable() {

        luckPerms = LuckPermsProvider.get();

        loadNPCPool();
        registerListeners();
        loadCommands();

        utils = new Utils();
        items = new Items();
        titles = new Titles();
        inventorys = new Inventorys();
        perms = new Perms();

        ConfigFile configFile = new ConfigFile();
        configFile.setStandard();
        configFile.readData();

        CoinAPI coinsAPI = new CoinAPI();
        CoinAPI.readConfig();

        KillDeathAPI killDeathAPI = new KillDeathAPI();
        KillDeathAPI.readConfig();
    }

    @Override
    public void onDisable() {
    }

    private void loadNPCPool() {
        npcPool = NPCPool.builder(this).spawnDistance(50).actionDistance(50).tabListRemoveTicks(20).build();
        npcUtil = new NPCUtil();
    }

    public void registerListeners() {
        PluginManager pm = Bukkit.getPluginManager();
        pm.registerEvents(new BuildListener(), this);
        pm.registerEvents(new InventoryClickListener(), this);
        pm.registerEvents(new PlayerJoinListener(), this);
        pm.registerEvents(new PlayerMoveListener(), this);
        pm.registerEvents(new WeatherChangeListener(), this);
    }

    public void loadCommands() {
        getCommand("blocks").setExecutor(new BlocksCommand());
        getCommand("broadcast").setExecutor(new BroadCastCommand());
        getCommand("chatclear").setExecutor(new ChatClearCommand());
        getCommand("coins").setExecutor(new CoinsCommand());
        getCommand("feed").setExecutor(new FeedCommand());
        getCommand("setup").setExecutor(new SetupCommand());
        getCommand("spawn").setExecutor(new SpawnCommand());
    }

    public static SkyPvP getInstance() {
        return instance;
    }

    public NPCPool getNpcPool() {
        return npcPool;
    }

    public NPCUtil getNpcUtil() {
        return npcUtil;
    }

    public LocationAPI getLocationAPI() {
        return locationAPI;
    }

    public LuckPerms getLuckPerms() {
        return luckPerms;
    }

    public Utils getUtils() {
        return utils;
    }

    public Items getItems() {
        return items;
    }

    public Titles getTitles() {
        return titles;
    }

    public Inventorys getInventorys() {
        return inventorys;
    }

    public Perms getPerms() {
        return perms;
    }
}
