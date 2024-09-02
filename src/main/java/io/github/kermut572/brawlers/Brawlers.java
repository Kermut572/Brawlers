package io.github.kermut572.brawlers;

import io.github.kermut572.brawlers.listeners.LobbyListener;
import io.github.kermut572.brawlers.managers.GameManager;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.plugin.java.JavaPlugin;

import java.io.File;

public final class Brawlers extends JavaPlugin {

    private GameManager gameManager;

    private Arena arena;
    private File arenaFile = new File(getDataFolder(), "arenas.yml");
    private FileConfiguration arenaConfig = YamlConfiguration.loadConfiguration(arenaFile);

    @Override
    public void onEnable() {
        if(!arenaFile.exists()){
            saveResource("arenas.yml", false);
        }

        this.gameManager = new GameManager(this);
        getServer().getPluginManager().registerEvents(new LobbyListener(gameManager), this);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    public FileConfiguration getArenaConfig(){
        return arenaConfig;
    }
}
