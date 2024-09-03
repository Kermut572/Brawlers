package io.github.kermut572.brawlers;

import io.github.kermut572.brawlers.listeners.DamageListener;
import io.github.kermut572.brawlers.listeners.LobbyListener;
import io.github.kermut572.brawlers.managers.GameManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scheduler.BukkitRunnable;

import java.io.File;

public final class Brawlers extends JavaPlugin {

    private GameManager gameManager;

    private Brawlers plugin;
    private Arena arena;
    private final File arenaFile = new File(getDataFolder(), "arena.yml");
    private final FileConfiguration arenaConfig = YamlConfiguration.loadConfiguration(arenaFile);

    @Override
    public void onEnable() {
        plugin = this;
        if(!arenaFile.exists()){
            saveResource("arena.yml", false);
        }
        plugin.gameManager = new GameManager(plugin);
        getServer().getPluginManager().registerEvents(new LobbyListener(gameManager), plugin);
        getServer().getPluginManager().registerEvents(new DamageListener(gameManager), plugin);
        new BukkitRunnable() {
            @Override
            public void run() {
                arena = new Arena(gameManager);
                gameManager.setArena(arena);
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

    public Arena getArena() {
        return arena;
    }
}
