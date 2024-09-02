package io.github.kermut572.brawlers.managers;

import io.github.kermut572.brawlers.Arena;
import io.github.kermut572.brawlers.Brawlers;
import io.github.kermut572.brawlers.enums.GameState;

public class GameManager {

    private final Brawlers plugin;
    private final Arena arena;
    private GameState gameState;
    private final PlayerManager playerManager;

    public GameManager(Brawlers plugin){
        this.plugin = plugin;
        this.arena = new Arena(this);
        this.playerManager = new PlayerManager(this);
        this.gameState = GameState.LOBBY;
    }

    public Brawlers getPlugin(){
        return plugin;
    }

    public Arena getArena(){
        return arena;
    }

    public GameState getGameState(){
        return gameState;
    }

    public void setGameState(GameState gameState){
        this.gameState = gameState;
    }

    public PlayerManager getPlayerManager(){
        return playerManager;
    }

}
