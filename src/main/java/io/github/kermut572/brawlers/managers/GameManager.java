package io.github.kermut572.brawlers.managers;

import io.github.kermut572.brawlers.gameobjects.Arena;
import io.github.kermut572.brawlers.Brawlers;
import io.github.kermut572.brawlers.enums.GameState;
import io.github.kermut572.brawlers.runnables.RestartServer;
import io.github.kermut572.brawlers.runnables.SpawnItem;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class GameManager {

    private final Brawlers plugin;
    private Arena arena;
    private GameState gameState;
    private final PlayerManager playerManager;
    private final BrawlItemManager brawlItemManager;
    private final String gameTag = ChatColor.YELLOW + "[" + ChatColor.RED + "Brawlers" + ChatColor.YELLOW + "] " + ChatColor.RESET;

    public GameManager(Brawlers plugin){
        this.plugin = plugin;
        this.playerManager = new PlayerManager(this);
        this.brawlItemManager = new BrawlItemManager(this);
        this.gameState = GameState.LOBBY;
    }

    public Brawlers getPlugin(){
        return plugin;
    }

    public void setArena(Arena arena){
        this.arena = arena;
    }

    public String getGameTag() {
        return gameTag;
    }

    public Arena getArena(){
        return arena;
    }

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState gameState){
        if(gameState == GameState.RESTARTING){
            Player winner = playerManager.getPlayers().values().iterator().next().getPlayer();
            RestartServer restartServer = new RestartServer(this);
            restartServer.runTaskTimer(plugin, 0, 20);
            Bukkit.getServer().broadcastMessage(ChatColor.GOLD + winner.getDisplayName() + " has won the game!");
            Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Game restarting in 10 seconds");
            Bukkit.getLogger().log(java.util.logging.Level.INFO, "Launch task to restart here");
        }
        if(gameState == GameState.INGAME){
            SpawnItem spawnItem = new SpawnItem(this);
            spawnItem.runTaskTimer(plugin, 0, 100);
        }
        this.gameState = gameState;
    }

    public PlayerManager getPlayerManager(){
        return playerManager;
    }

    public BrawlItemManager getBrawlItemManager(){
        return brawlItemManager;
    }

}
