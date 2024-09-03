package io.github.kermut572.brawlers.managers;

import io.github.kermut572.brawlers.Arena;
import io.github.kermut572.brawlers.Brawlers;
import io.github.kermut572.brawlers.enums.GameState;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.World;
import org.bukkit.entity.Player;

public class GameManager {

    private final Brawlers plugin;
    private Arena arena;
    private GameState gameState;
    private final PlayerManager playerManager;

    public GameManager(Brawlers plugin){
        this.plugin = plugin;
        this.playerManager = new PlayerManager(this);
        this.gameState = GameState.LOBBY;
    }

    public Brawlers getPlugin(){
        return plugin;
    }

    public void setArena(Arena arena){
        this.arena = arena;
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
            Bukkit.getServer().broadcastMessage(ChatColor.GOLD + winner.getDisplayName() + " has won the game!");
            Bukkit.getServer().broadcastMessage(ChatColor.GREEN + "Game restarting in 10 seconds");
            Bukkit.getLogger().log(java.util.logging.Level.INFO, "Launch task to restart here");
        }
        this.gameState = gameState;
    }

    public PlayerManager getPlayerManager(){
        return playerManager;
    }

}
