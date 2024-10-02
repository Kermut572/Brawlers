package io.github.kermut572.brawlers;

import io.github.kermut572.brawlers.commands.SetPointCommand;
import io.github.kermut572.brawlers.gameobjects.Arena;
import io.github.kermut572.brawlers.listeners.BrawlItemListener;
import io.github.kermut572.brawlers.listeners.DamageListener;
import io.github.kermut572.brawlers.listeners.LobbyListener;
import io.github.kermut572.brawlers.managers.GameManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;
import java.util.logging.Logger;

public final class Brawlers extends JavaPlugin {

    private GameManager gameManager;

    private Brawlers plugin;
    private Arena arena;
    private final File arenaFile = new File(getDataFolder(), "arena.yml");
    private final File ItemFile = new File(getDataFolder(), "items.yml");
    private final FileConfiguration arenaConfig = YamlConfiguration.loadConfiguration(arenaFile);
    private final FileConfiguration itemConfig = YamlConfiguration.loadConfiguration(ItemFile);

    @Override
    public void onEnable() {
        plugin = this;

        //TODO on the first enable, the arena cannot be parsed from the config file. Fix so it doesn't break the plugin
        if(!arenaFile.exists()){
            saveResource("arena.yml", false);
        }
        if(!ItemFile.exists()){
            saveResource("items.yml", false);
        }
        plugin.gameManager = new GameManager(plugin);
        getServer().getPluginManager().registerEvents(new LobbyListener(gameManager), plugin);
        getServer().getPluginManager().registerEvents(new DamageListener(gameManager), plugin);
        getServer().getPluginManager().registerEvents(new BrawlItemListener(gameManager), plugin);
        getCommand("setpoint").setExecutor(new SetPointCommand(gameManager));
        new BukkitRunnable() {
            @Override
            public void run() {
                arena = new Arena(gameManager);
                gameManager.setArena(arena);
                gameManager.getBrawlItemManager().parseItemConfig();
            }
        }.runTaskLater(this, 1);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public FileConfiguration getArenaConfig(){
        return arenaConfig;
    }

    public FileConfiguration getItemConfig(){
        return itemConfig;
    }

    public Arena getArena() {
        return arena;
    }

    public void saveArenaConfig() {
        try {
            arenaConfig.save(arenaFile);
        } catch (Exception e) {
            Logger.getLogger("Minecraft").info("Could not save arena config");
        }
    }
}
